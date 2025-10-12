package com.daoqonq1408.workshopbesql.mapper;

import com.daoqonq1408.workshopbesql.dto.request.GradeRequest;
import com.daoqonq1408.workshopbesql.dto.response.GradeResponse;
import com.daoqonq1408.workshopbesql.entity.Grade;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeMapper {

    private final SubjectService subjectService;


    public GradeResponse toResponse(Grade grade) {
        return GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .subjectId(grade.getSubject().getId())
                .build();
    }


    public Grade toEntity(GradeRequest gradeRequest) {
        return Grade.builder()
                .grade(gradeRequest.getGrade())
                .subject(subjectService.findById(gradeRequest.getSubjectId()))
                .build();
    }
}
