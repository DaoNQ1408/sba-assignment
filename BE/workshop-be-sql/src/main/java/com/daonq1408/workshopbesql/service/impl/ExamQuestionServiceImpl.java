package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.ExamQuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ExamQuestionResponse;
import com.daonq1408.workshopbesql.entity.ExamQuestion;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.ExamQuestionMapper;
import com.daonq1408.workshopbesql.repository.ExamQuestionRepository;
import com.daonq1408.workshopbesql.service.ExamQuestionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExamQuestionServiceImpl implements ExamQuestionService {

    private final ExamQuestionRepository examQuestionRepository;
    private final ExamQuestionMapper examQuestionMapper;


    @Override
    public ExamQuestion findById(long examQuestionId) {
        return examQuestionRepository.findById(examQuestionId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Exam Question not found with id " +
                                examQuestionId)
                );
    }


    @Override
    public ExamQuestionResponse findResponseById(long examQuestionId) {

        ExamQuestion examQuestion = findById(examQuestionId);

        return examQuestionMapper.toResponse(examQuestion);
    }


    @Override
    public List<ExamQuestionResponse> getAll() {
        return examQuestionRepository.findAll().stream()
                .map(examQuestionMapper::toResponse)
                .toList();
    }


    @Override
    public List<ExamQuestionResponse> findByExamId(long examId) {
        return examQuestionRepository.findByExamId(examId).stream()
                .map(examQuestionMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public ExamQuestionResponse saveExamQuestion(ExamQuestionRequest request) {

        validateQuestionNotInExam(request.getExamId(), request.getQuestionId());

        ExamQuestion examQuestion = examQuestionMapper.toEntity(request);

        ExamQuestion savedExamQuestion = examQuestionRepository.save(examQuestion);

        return examQuestionMapper.toResponse(savedExamQuestion);
    }


    @Override
    @Transactional
    public ExamQuestionResponse updateExamQuestion(long examQuestionId, ExamQuestionRequest request) {

        ExamQuestion examQuestion = findById(examQuestionId);

        examQuestionMapper.updateEntityFromRequest(examQuestion, request);

        ExamQuestion updatedExamQuestion = examQuestionRepository.save(examQuestion);

        return examQuestionMapper.toResponse(updatedExamQuestion);
    }


    @Override
    @Transactional
    public ExamQuestionResponse deleteExamQuestion(long examQuestionId) {

        ExamQuestion examQuestion = findById(examQuestionId);

        examQuestionRepository.delete(examQuestion);

        return examQuestionMapper.toResponse(examQuestion);
    }


    public void validateQuestionNotInExam(long examId, long questionId) {
        if(examQuestionRepository.existsByExamIdAndQuestionId(examId, questionId)) {
            throw new DuplicateObjectException("Question already exists in the exam");
        }
    }
}
