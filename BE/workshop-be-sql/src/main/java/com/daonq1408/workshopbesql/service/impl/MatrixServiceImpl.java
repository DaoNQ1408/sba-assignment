package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.entity.Matrix;
import com.daonq1408.workshopbesql.repository.MatrixRepository;
import com.daonq1408.workshopbesql.service.MatrixService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MatrixServiceImpl implements MatrixService {

    private final MatrixRepository matrixRepository;


    @Override
    public Matrix findById(long matrixId) {
        return matrixRepository.findById(matrixId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Matrix not found with id " +
                                matrixId)
                );
    }
}
