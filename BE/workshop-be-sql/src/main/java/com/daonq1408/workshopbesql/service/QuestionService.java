package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.entity.Question;

public interface QuestionService {
    Question findById(long questionId);
}
