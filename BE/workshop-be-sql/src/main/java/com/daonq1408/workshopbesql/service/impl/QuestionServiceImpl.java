package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.entity.Question;
import com.daonq1408.workshopbesql.repository.QuestionRepository;
import com.daonq1408.workshopbesql.service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;


    @Override
    public Question findById(long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Question not found with id " +
                                questionId)
                );
    }
}
