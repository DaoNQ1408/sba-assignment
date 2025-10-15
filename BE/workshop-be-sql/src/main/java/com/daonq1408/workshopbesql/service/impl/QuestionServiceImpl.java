package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.QuestionRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionResponse;
import com.daonq1408.workshopbesql.entity.Question;
import com.daonq1408.workshopbesql.mapper.QuestionMapper;
import com.daonq1408.workshopbesql.repository.QuestionRepository;
import com.daonq1408.workshopbesql.service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;


    @Override
    public Question findById(long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Question not found with id " +
                                questionId)
                );
    }


    @Override
    public QuestionResponse findResponseById(long questionId) {
        return questionMapper.toResponse(findById(questionId));
    }


    @Override
    public List<QuestionResponse> findAllQuestions() {
        return questionRepository
                .findAll()
                .stream()
                .map(questionMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public QuestionResponse saveQuestion(QuestionRequest questionRequest) {

        Question question = questionMapper.toEntity(questionRequest);

        Question savedQuestion = questionRepository.save(question);

        return questionMapper.toResponse(savedQuestion);
    }


    @Override
    @Transactional
    public QuestionResponse updateQuestion(long questionId, QuestionRequest questionRequest) {

        Question question = findById(questionId);

        questionMapper.updateEntityFromRequest(question, questionRequest);
        Question updatedQuestion = questionRepository.save(question);

        return questionMapper.toResponse(updatedQuestion);
    }


    @Override
    @Transactional
    public QuestionResponse deleteQuestion(long questionId) {

        Question question = findById(questionId);

        questionRepository.delete(question);

        return questionMapper.toResponse(question);
    }
}
