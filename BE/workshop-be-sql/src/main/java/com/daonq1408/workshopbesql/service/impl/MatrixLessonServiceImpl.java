package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.MatrixLessonRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixLessonResponse;
import com.daonq1408.workshopbesql.entity.MatrixLesson;
import com.daonq1408.workshopbesql.mapper.MatrixLessonMapper;
import com.daonq1408.workshopbesql.repository.MatrixLessonRepository;
import com.daonq1408.workshopbesql.service.MatrixLessonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatrixLessonServiceImpl implements MatrixLessonService {

    private final MatrixLessonRepository matrixLessonRepository;
    private final MatrixLessonMapper matrixLessonMapper;

    @Override
    public MatrixLesson findById(long matrixLessonId) {
        return matrixLessonRepository.findById(matrixLessonId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "MatrixLesson not found with id " +
                                        matrixLessonId)
                );
    }


    @Override
    public MatrixLessonResponse findResponseById(long matrixLessonId) {

        MatrixLesson matrixLesson = findById(matrixLessonId);

        return matrixLessonMapper.toResponse(matrixLesson);
    }


    @Override
    public List<MatrixLessonResponse> getAll() {
        return matrixLessonRepository.findAll().stream()
                .map(matrixLessonMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public MatrixLessonResponse saveMatrixLesson(MatrixLessonRequest request) {

        MatrixLesson matrixLesson = matrixLessonMapper.toEntity(request);

        MatrixLesson savedMatrixLesson = matrixLessonRepository.save(matrixLesson);

        return matrixLessonMapper.toResponse(savedMatrixLesson);
    }


    @Override
    @Transactional
    public MatrixLessonResponse updateMatrixLesson(long matrixLessonId, MatrixLessonRequest request) {

        MatrixLesson matrixLesson = findById(matrixLessonId);

        matrixLessonMapper.updateEntityFromRequest(matrixLesson,request);

        MatrixLesson savedMatrixLesson = matrixLessonRepository.save(matrixLesson);

        return matrixLessonMapper.toResponse(savedMatrixLesson);
    }


    @Override
    @Transactional
    public MatrixLessonResponse deleteMatrixLesson(long matrixLessonId) {

        MatrixLesson matrixLesson = findById(matrixLessonId);

        matrixLessonRepository.delete(matrixLesson);

        return matrixLessonMapper.toResponse(matrixLesson);
    }
}
