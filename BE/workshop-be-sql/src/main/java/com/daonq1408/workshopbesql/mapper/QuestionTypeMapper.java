package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.entity.QuestionType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface QuestionTypeMapper {

    QuestionTypeResponse toResponse(QuestionType questionType);


    QuestionType toEntity(QuestionTypeRequest questionTypeRequest);
}
