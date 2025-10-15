package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;
import com.daonq1408.workshopbesql.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {QuestionService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {

    @Mapping(source = "question.id", target = "questionId")
    OptionResponse toResponse(Option option);


    @Mapping(source = "questionId", target = "question")
    Option toEntity(OptionRequest optionRequest);
}
