package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.GradeRequest;
import com.daonq1408.workshopbesql.dto.response.GradeResponse;
import com.daonq1408.workshopbesql.entity.Grade;
import com.daonq1408.workshopbesql.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {SubjectService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GradeMapper {

    @Mapping(source = "subject.id", target = "subjectId")
    GradeResponse toResponse(Grade grade);


    @Mapping(source = "subjectId", target = "subject")
    Grade toEntity(GradeRequest gradeRequest);
}
