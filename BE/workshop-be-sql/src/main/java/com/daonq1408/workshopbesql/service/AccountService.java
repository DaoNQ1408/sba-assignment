package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;

import java.util.List;

public interface AccountService {
    Account findById(long accountId);
    Account findByMail(String mail);
    AccountResponse getById(long accountId);
    List<AccountResponse> getAll();
    AccountResponse saveAccount(AccountRequest accountRequest);
    AccountResponse updateAccount(long accountId, AccountRequest accountRequest);
    AccountResponse deleteAccount(long accountId);
}
