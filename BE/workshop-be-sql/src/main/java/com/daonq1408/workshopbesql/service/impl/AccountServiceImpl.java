package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.AccountMapper;
import com.daonq1408.workshopbesql.repository.AccountRepository;
import com.daonq1408.workshopbesql.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public AccountResponse getById(long accountId) {
        return accountMapper.toResponse(findById(accountId));
    }


    @Override
    public List<AccountResponse> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public AccountResponse saveAccount(AccountRequest accountRequest) {

        endIfMailExists(accountRequest.getMail());

        Account account = accountMapper.toEntity(accountRequest);
        Account savedAccount = accountRepository.save(account);

        return accountMapper.toResponse(savedAccount);
    }


    @Override
    @Transactional
    public AccountResponse updateAccount(long accountId, AccountRequest accountRequest) {

        Account account = findById(accountId);

        accountMapper.updateEntityFromRequest(account, accountRequest);
        Account updatedAccount = accountRepository.save(account);

        return accountMapper.toResponse(accountRepository.save(updatedAccount));
    }


    @Override
    @Transactional
    public AccountResponse deleteAccount(long accountId) {

        Account account = findById(accountId);

        accountRepository.delete(account);

        return accountMapper.toResponse(account);
    }


    @Override
    public Account findById(long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Account not found with id " +
                                accountId)
                );
    }

    @Override
    public Account findByMail(String mail) {
        return accountRepository.findByMail(mail)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Account not found with mail " +
                                mail)
                );
    }


    public void endIfMailExists(String mail) {
        accountRepository.findByMail(mail)
                .ifPresent(a -> {throw new DuplicateObjectException(
                        "Account already exists with mail: " +
                                mail);
                });
    }
}
