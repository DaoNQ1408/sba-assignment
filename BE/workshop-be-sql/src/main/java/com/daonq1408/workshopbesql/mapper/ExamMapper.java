package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.entity.Exam;

import com.daonq1408.workshopbesql.service.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamMapper {

    private final MatrixService matrixService;


    public ExamResponse toResponse(Exam exam) {
        return ExamResponse.builder()
                .id(exam.getId())
                .title(exam.getTitle())
                .durationMinutes(exam.getDurationMinutes())
                .matrixId(exam.getMatrix().getId())
                .build();
    }


    public Exam toEntity(ExamRequest examRequest) {
        return Exam.builder()
                .title(examRequest.getTitle())
                .durationMinutes(examRequest.getDurationMinutes())
                .matrix(matrixService.findById(examRequest.getMatrixId()))
                .build();
    }
}
