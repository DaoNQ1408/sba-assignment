package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {PasswordEncoder.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    @Mapping(target = "mail", source = "mail")
    AccountResponse toResponse(Account account);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(accountRequest.getPassword()))")
    @Mapping(target = "mail", source = "mail")
    Account toEntity(AccountRequest accountRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Account account,
                                AccountRequest accountRequest);
}
