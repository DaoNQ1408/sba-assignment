package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.entity.QuestionType;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.QuestionTypeMapper;
import com.daonq1408.workshopbesql.repository.QuestionTypeRepository;
import com.daonq1408.workshopbesql.service.QuestionTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionTypeService {

    private final QuestionTypeRepository questionTypeRepository;
    private final QuestionTypeMapper questionTypeMapper;


    public void endIfExistQuestionTypeName(String name) {
        questionTypeRepository.findByName(name)
                .ifPresent(questionType -> {
                    throw new DuplicateObjectException(
                            "QuestionType already exist with name: " +
                                    name);
                });
    }

    @Override
    public QuestionType findById(long questionTypeId) {
        return questionTypeRepository.findById(questionTypeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "QuestionType not found with id " +
                                questionTypeId)
                );
    }


    @Override
    public QuestionTypeResponse getById(long questionTypeId) {
        return questionTypeMapper
                .toResponse(findById(questionTypeId));
    }


    @Override
    public List<QuestionTypeResponse> findAll() {
        return questionTypeRepository.findAll().stream()
                .map(questionTypeMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public QuestionTypeResponse save(QuestionTypeRequest questionTypeRequest) {

        endIfExistQuestionTypeName(questionTypeRequest.getName());

        QuestionType questionType = questionTypeMapper.toEntity(questionTypeRequest);
        QuestionType savedQuestionType = questionTypeRepository.save(questionType);

        return questionTypeMapper.toResponse(savedQuestionType);
    }


    @Override
    @Transactional
    public QuestionTypeResponse update(long questionTypeId, QuestionTypeRequest questionTypeRequest) {

        QuestionType questionType = findById(questionTypeId);

        questionTypeMapper.updateEntityFromRequest(questionType, questionTypeRequest);
        QuestionType updatedQuestionType = questionTypeRepository.save(questionType);

        return questionTypeMapper.toResponse(updatedQuestionType);
    }


    @Override
    @Transactional
    public QuestionTypeResponse delete(long questionTypeId) {

        QuestionType questionType = findById(questionTypeId);

        questionTypeRepository.delete(questionType);

        return questionTypeMapper.toResponse(questionType);
    }
}
