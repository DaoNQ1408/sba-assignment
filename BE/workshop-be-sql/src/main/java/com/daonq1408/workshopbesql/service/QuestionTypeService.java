package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.entity.QuestionType;

import java.util.List;

public interface QuestionTypeService {
    QuestionType findById(long questionTypeId);
    QuestionTypeResponse getById(long questionTypeId);
    List<QuestionTypeResponse> findAll();
    QuestionTypeResponse save(QuestionTypeRequest questionTypeRequest);
    QuestionTypeResponse update(long questionTypeId, QuestionTypeRequest questionTypeRequest);
    QuestionTypeResponse delete(long questionTypeId);
}
