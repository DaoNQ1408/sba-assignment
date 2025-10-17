package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.LessonRequest;
import com.daonq1408.workshopbesql.dto.response.LessonResponse;
import com.daonq1408.workshopbesql.entity.Lesson;
import com.daonq1408.workshopbesql.service.GradeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {GradeService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LessonMapper {

    @Mapping(source = "grade.id", target = "gradeId")
    LessonResponse toResponse(Lesson lesson);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grade", source = "gradeId")
    Lesson toEntity(LessonRequest lessonRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grade", source = "gradeId")
    void updateEntityFromRequest(@MappingTarget Lesson lesson,
                                 LessonRequest lessonRequest);
}
