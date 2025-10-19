package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.UserRequest;
import com.daonq1408.workshopbesql.dto.response.UserResponse;
import com.daonq1408.workshopbesql.entity.User;
import com.daonq1408.workshopbesql.service.AccountService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {AccountService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "accountId", source = "account.id")
    UserResponse toResponse(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "account", source = "accountId")
    User toEntity(UserRequest userRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget User user,
                                 UserRequest userRequest);
}
