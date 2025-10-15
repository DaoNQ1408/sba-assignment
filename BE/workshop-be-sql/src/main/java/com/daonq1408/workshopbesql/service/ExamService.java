package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.entity.Exam;

import java.util.List;

public interface ExamService {
    Exam findById(long examId);
    ExamResponse getById(long examId);
    List<ExamResponse> getAll();
    ExamResponse saveExam(ExamRequest examRequest);
    ExamResponse updateExam(long examId, ExamRequest examRequest);
    ExamResponse deleteExam(long examId);
}
