package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.MatrixRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixResponse;
import com.daonq1408.workshopbesql.entity.Matrix;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.MatrixMapper;
import com.daonq1408.workshopbesql.repository.MatrixRepository;
import com.daonq1408.workshopbesql.service.MatrixService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatrixServiceImpl implements MatrixService {

    private final MatrixRepository matrixRepository;
    private final MatrixMapper matrixMapper;


    @Override
    public Matrix findById(long matrixId) {
        return matrixRepository.findById(matrixId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Matrix not found with id " +
                                        matrixId)
                );
    }


    @Override
    public MatrixResponse findResponseById(long matrixId) {
        return matrixMapper.toResponse(findById(matrixId));
    }


    @Override
    public List<MatrixResponse> getAll() {
        return matrixRepository.findAll().stream()
                .map(matrixMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public MatrixResponse saveMatrix(MatrixRequest matrixRequest) {

        validateIfMatrixTitleExists(matrixRequest.getTitle());

        Matrix matrix = matrixMapper.toEntity(matrixRequest);

        return matrixMapper.toResponse(matrixRepository.save(matrix));
    }


    @Override
    @Transactional
    public MatrixResponse updateMatrix(long matrixId, MatrixRequest matrixRequest) {

        Matrix matrix = findById(matrixId);

        matrixMapper.updateEntityFromRequest(matrix, matrixRequest);

        Matrix updatedMatrix = matrixRepository.save(matrix);

        return matrixMapper.toResponse(updatedMatrix);
    }


    @Override
    @Transactional
    public MatrixResponse deleteMatrix(long matrixId) {

        Matrix matrix = findById(matrixId);

        matrixRepository.delete(matrix);

        return matrixMapper.toResponse(matrix);
    }


    public void validateIfMatrixTitleExists(String matrixTitle) {
        matrixRepository.findByTitle(matrixTitle)
                .ifPresent(m -> {
                    throw new DuplicateObjectException(
                            "Matrix already exists with title: " +
                                    matrixTitle);
                });
    }
}
