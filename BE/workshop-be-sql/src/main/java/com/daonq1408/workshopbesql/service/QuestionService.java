package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.QuestionRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionResponse;
import com.daonq1408.workshopbesql.entity.Question;

import java.util.List;

public interface QuestionService {
    Question findById(long questionId);
    QuestionResponse findResponseById(long questionId);
    List<QuestionResponse> findAllQuestions();
    QuestionResponse saveQuestion(QuestionRequest questionRequest);
    QuestionResponse updateQuestion(long questionId, QuestionRequest questionRequest);
    QuestionResponse deleteQuestion(long questionId);
}
