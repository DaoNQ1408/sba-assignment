package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.GradeRequest;
import com.daonq1408.workshopbesql.dto.response.GradeResponse;
import com.daonq1408.workshopbesql.entity.Grade;
import com.daonq1408.workshopbesql.service.SubjectService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {SubjectService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GradeMapper {

    @Mapping(target = "subjectId", source = "subject.id")
    GradeResponse toResponse(Grade grade);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subject", source = "subjectId")
    Grade toEntity(GradeRequest gradeRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subject", source = "subjectId")
    void updateEntityFromRequest(@MappingTarget Grade grade,
                                 GradeRequest gradeRequest);
}
