package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.entity.QuestionType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionTypeMapper {

    QuestionTypeResponse toResponse(QuestionType questionType);


    @Mapping(target = "id", ignore = true)
    QuestionType toEntity(QuestionTypeRequest questionTypeRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget QuestionType questionType,
                                 QuestionTypeRequest questionTypeRequest);
}
