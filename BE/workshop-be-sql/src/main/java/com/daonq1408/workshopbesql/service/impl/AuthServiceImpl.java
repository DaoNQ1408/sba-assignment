package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.config.JwtTokenProvider;
import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.request.RegisterRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.dto.response.AuthResponse;
import com.daonq1408.workshopbesql.entity.Account;
import com.daonq1408.workshopbesql.entity.User;
import com.daonq1408.workshopbesql.enums.Role;
import com.daonq1408.workshopbesql.mapper.AccountMapper;
import com.daonq1408.workshopbesql.repository.AccountRepository;
import com.daonq1408.workshopbesql.repository.UserRepository;
import com.daonq1408.workshopbesql.service.AccountService;
import com.daonq1408.workshopbesql.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AuthResponse login(AccountRequest accountRequest) {
        Account account = accountService.findByMail(accountRequest.getMail());
        if (account != null) {
            if(passwordEncoder.matches(accountRequest.getPassword(), account.getPassword())) {
                String token = jwtTokenProvider.generateToken(account);
                return new AuthResponse(token);
            }
        }
        return null;
    }

    @Override
    public AccountResponse register(RegisterRequest registerRequest) {
        Account account = accountRepository.findByMail(registerRequest.getMail()).orElse(null);
        if (account == null) {
            Account newAccount = new Account();
            newAccount.setMail(registerRequest.getMail());
            newAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            newAccount.setRole(Role.USER);

            Account savedAccount = accountRepository.save(newAccount);
            User user = new User();
            user.setAccount(savedAccount);
            user.setName(registerRequest.getFullName());
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
            return accountMapper.toResponse(savedAccount);
        }
        return null;
    }
}
