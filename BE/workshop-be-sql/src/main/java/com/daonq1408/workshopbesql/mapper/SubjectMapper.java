package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daonq1408.workshopbesql.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectMapper {

    SubjectResponse toResponse(Subject subject);


    @Mapping(target = "id", ignore = true)
    Subject toEntity(SubjectRequest subjectRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Subject subject,
                                 SubjectRequest subjectRequest);
}
