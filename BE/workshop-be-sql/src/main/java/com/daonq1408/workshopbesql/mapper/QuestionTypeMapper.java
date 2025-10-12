package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.entity.QuestionType;
import org.springframework.stereotype.Component;

@Component
public class QuestionTypeMapper {

    public QuestionTypeResponse toResponse(QuestionType questionType) {
        return QuestionTypeResponse.builder()
                .id(questionType.getId())
                .name(questionType.getName())
                .build();
    }


    public QuestionType toEntity(QuestionTypeRequest questionTypeRequest) {
        return QuestionType.builder()
                .name(questionTypeRequest.getName())
                .build();
    }
}
