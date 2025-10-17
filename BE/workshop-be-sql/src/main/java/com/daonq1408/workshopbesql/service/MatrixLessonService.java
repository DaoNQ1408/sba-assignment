package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.MatrixLessonRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixLessonResponse;
import com.daonq1408.workshopbesql.entity.MatrixLesson;

import java.util.List;

public interface MatrixLessonService {
    MatrixLesson findById(long matrixLessonId);
    MatrixLessonResponse findResponseById(long matrixLessonId);
    List<MatrixLessonResponse> getAll();
    MatrixLessonResponse saveMatrixLesson(MatrixLessonRequest request);
    MatrixLessonResponse updateMatrixLesson(long matrixLessonId, MatrixLessonRequest request);
    MatrixLessonResponse deleteMatrixLesson(long matrixLessonId);
}
