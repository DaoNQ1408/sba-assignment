package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.MatrixLessonRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixLessonResponse;
import com.daonq1408.workshopbesql.entity.MatrixLesson;
import com.daonq1408.workshopbesql.service.LessonService;
import com.daonq1408.workshopbesql.service.LevelService;
import com.daonq1408.workshopbesql.service.MatrixService;
import com.daonq1408.workshopbesql.service.QuestionTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {MatrixService.class,
                LessonService.class,
                LevelService.class,
                QuestionTypeService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatrixLessonMapper {

    @Mapping(target = "matrixId", source = "matrix.id")
    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "levelId", source = "level.id")
    @Mapping(target = "questionTypeId", source = "questionType.id")
    MatrixLessonResponse toResponse(MatrixLesson matrixLesson);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "matrix", source = "matrixId")
    @Mapping(target = "lesson", source = "lessonId")
    @Mapping(target = "level", source = "levelId")
    @Mapping(target = "questionType", source = "questionTypeId")
    MatrixLesson toEntity(MatrixLessonRequest matrixLessonRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "matrix", source = "matrixId")
    @Mapping(target = "lesson", source = "lessonId")
    @Mapping(target = "level", source = "levelId")
    @Mapping(target = "questionType", source = "questionTypeId")
    void updateEntityFromRequest(@MappingTarget MatrixLesson matrixLesson,
                                  MatrixLessonRequest matrixLessonRequest);
}
