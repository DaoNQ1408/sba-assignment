package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.TeacherRequest;
import com.daonq1408.workshopbesql.dto.response.TeacherResponse;
import com.daonq1408.workshopbesql.entity.Teacher;
import com.daonq1408.workshopbesql.service.AccountService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = AccountService.class, unmappedTargetPolicy =
        ReportingPolicy.IGNORE)
public interface TeacherMapper {

    @Mapping(target = "accountId", source = "account.id")
    TeacherResponse toResponse(Teacher teacher);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "account", source = "accountId")
    Teacher toEntity(TeacherRequest teacherRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Teacher teacher,
                                 TeacherRequest teacherRequest);
}
