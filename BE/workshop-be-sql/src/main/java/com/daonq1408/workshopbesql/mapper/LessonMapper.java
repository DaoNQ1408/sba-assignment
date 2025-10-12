package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.LessonRequest;
import com.daonq1408.workshopbesql.dto.response.LessonResponse;
import com.daonq1408.workshopbesql.entity.Lesson;
import com.daonq1408.workshopbesql.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonMapper {

    private final GradeService gradeService;


    public LessonResponse toResponse(Lesson lesson) {
        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .gradeId(lesson.getGrade().getId())
                .build();
    }


    public Lesson toEntity(LessonRequest lessonRequest) {
        return Lesson.builder()
                .title(lessonRequest.getTitle())
                .grade(gradeService.findById(lessonRequest.getGradeId()))
                .build();
    }
}
