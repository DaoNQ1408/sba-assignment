package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponse toResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .mail(account.getMail())
                .build();
    }


    public Account toEntity(AccountRequest accountRequest) {
        return Account.builder()
                .mail(accountRequest.getMail())
                .password(accountRequest.getPassword())
                .build();
    }
}
