package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse toResponse(Account account);


    Account toEntity(AccountRequest accountRequest);
}
