package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;
import com.daonq1408.workshopbesql.service.QuestionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {QuestionService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {

    @Mapping(target = "questionId", source = "question.id")
    OptionResponse toResponse(Option option);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "question", source = "questionId")
    Option toEntity(OptionRequest optionRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "question", source = "questionId")
    void updateEntityFromRequest(@MappingTarget Option option,
                                 OptionRequest optionRequest);
}
