package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.MatrixRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixResponse;
import com.daonq1408.workshopbesql.entity.Matrix;

import java.util.List;

public interface MatrixService {
    Matrix findById(long matrixId);
    MatrixResponse findResponseById(long matrixId);
    List<MatrixResponse> getAll();
    MatrixResponse saveMatrix(MatrixRequest matrixRequest);
    MatrixResponse updateMatrix(long matrixId, MatrixRequest matrixRequest);
    MatrixResponse deleteMatrix(long matrixId);
}
