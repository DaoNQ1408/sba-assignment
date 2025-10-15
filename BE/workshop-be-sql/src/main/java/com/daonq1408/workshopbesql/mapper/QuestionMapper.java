package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.QuestionRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionResponse;
import com.daonq1408.workshopbesql.entity.Question;
import com.daonq1408.workshopbesql.service.LessonService;
import com.daonq1408.workshopbesql.service.LevelService;
import com.daonq1408.workshopbesql.service.QuestionTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {LessonService.class,
                LevelService.class,
                QuestionTypeService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    @Mapping(source = "lesson.id", target = "lessonId")
    @Mapping(source = "level.id", target = "levelId")
    @Mapping(source = "questionType.id", target = "questionTypeId")
    QuestionResponse toResponse(Question question);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "lessonId", target = "lesson")
    @Mapping(source = "levelId", target = "level")
    @Mapping(source = "questionTypeId", target = "questionType")
    Question toEntity(QuestionRequest questionRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Question question,
                                 QuestionRequest questionRequest);
}
