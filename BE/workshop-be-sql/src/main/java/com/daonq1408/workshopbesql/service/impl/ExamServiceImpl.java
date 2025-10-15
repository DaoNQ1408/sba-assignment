package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.entity.Exam;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.ExamMapper;
import com.daonq1408.workshopbesql.repository.ExamRepository;
import com.daonq1408.workshopbesql.service.ExamService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;


    @Override
    public Exam findById(long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Exam not found with id " +
                                examId)
                );
    }


    @Override
    public ExamResponse getById(long examId) {
        return examMapper.toResponse(findById(examId));
    }


    @Override
    public List<ExamResponse> getAll() {
        return examRepository
                .findAll()
                .stream()
                .map(examMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public ExamResponse saveExam(ExamRequest examRequest) {

        endIfExamTitleExists(examRequest.getTitle());

        Exam exam = examMapper.toEntity(examRequest);
        Exam savedExam = examRepository.save(exam);

        return examMapper.toResponse(savedExam);
    }


    @Override
    @Transactional
    public ExamResponse updateExam(long examId, ExamRequest examRequest) {

        Exam exam = findById(examId);

        examMapper.updateEntityFromRequest(exam, examRequest);
        Exam updatedExam = examRepository.save(exam);

        return examMapper.toResponse(updatedExam);
    }


    @Override
    @Transactional
    public ExamResponse deleteExam(long examId) {

        Exam exam = findById(examId);

        examRepository.delete(exam);

        return examMapper.toResponse(exam);
    }


    public void endIfExamTitleExists(String examTitle) {
        examRepository.findByTitle(examTitle)
                .ifPresent(e -> {
                    throw new DuplicateObjectException(
                            "Exam already exists with title: " +
                                    examTitle);
                });
    }
}
