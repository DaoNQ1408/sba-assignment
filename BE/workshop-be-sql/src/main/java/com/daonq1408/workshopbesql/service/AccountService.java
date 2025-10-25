package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {
    Account findById(long accountId);
    Account findByMail(String mail);
    AccountResponse getById(long accountId);
    List<AccountResponse> getAll();
    AccountResponse updateAccount(long accountId, AccountRequest accountRequest);
    AccountResponse deleteAccount(long accountId);
}
