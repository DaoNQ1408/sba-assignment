package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.ExamQuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ExamQuestionResponse;
import com.daonq1408.workshopbesql.entity.ExamQuestion;

import java.util.List;

public interface ExamQuestionService {
    ExamQuestion findById(long examQuestionId);
    ExamQuestionResponse findResponseById(long examQuestionId);
    List<ExamQuestionResponse> getAll();
    List<ExamQuestionResponse> findByExamId(long examId);
    ExamQuestionResponse saveExamQuestion(ExamQuestionRequest request);
    ExamQuestionResponse updateExamQuestion(long examQuestionId, ExamQuestionRequest request);
    ExamQuestionResponse deleteExamQuestion(long examQuestionId);
}
