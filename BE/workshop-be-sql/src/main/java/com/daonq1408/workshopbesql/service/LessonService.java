package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.LessonRequest;
import com.daonq1408.workshopbesql.dto.response.LessonResponse;
import com.daonq1408.workshopbesql.entity.Lesson;

import java.util.List;

public interface LessonService {
    LessonResponse getLesson(long lessonId);
    List<LessonResponse> getAllLessons();
    LessonResponse saveLesson(LessonRequest lessonRequest);
    LessonResponse updateLesson(long id, LessonRequest lessonRequest);
    LessonResponse deleteLesson(long lessonId);
    Lesson findById(long id);
}
