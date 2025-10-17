package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.ExamQuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ExamQuestionResponse;
import com.daonq1408.workshopbesql.entity.ExamQuestion;
import com.daonq1408.workshopbesql.service.ExamService;
import com.daonq1408.workshopbesql.service.QuestionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {ExamService.class,
                QuestionService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExamQuestionMapper {

    @Mapping(target = "examId", source = "exam.id")
    @Mapping(target = "questionId", source = "question.id")
    ExamQuestionResponse toResponse(ExamQuestion examQuestion);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "exam", source = "examId")
    @Mapping(target = "question", source = "questionId")
    ExamQuestion toEntity(ExamQuestionRequest examQuestionRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "exam", source = "examId")
    @Mapping(target = "question", source = "questionId")
    void updateEntityFromRequest(@MappingTarget ExamQuestion examQuestion,
                                 ExamQuestionRequest examQuestionRequest);
}
