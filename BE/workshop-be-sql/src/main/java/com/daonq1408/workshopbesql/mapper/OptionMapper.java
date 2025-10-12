package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;
import com.daonq1408.workshopbesql.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionMapper {

    private final QuestionService questionService;


    public OptionResponse toResponse(Option option) {
        return OptionResponse.builder()
                .optionId(option.getId())
                .option(option.getOption())
                .isTrue(option.isTrue())
                .questionId(option.getQuestion().getId())
                .build();
    }


    public Option toEntity(OptionRequest optionRequest) {
        return Option.builder()
                .option(optionRequest.getOption())
                .isTrue(optionRequest.isTrue())
                .question(questionService.findById(optionRequest.getQuestionId()))
                .build();
    }
}
