package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.MatrixRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.MatrixResponse;
import com.daonq1408.workshopbesql.service.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matrices")
@RequiredArgsConstructor
public class MatrixController {

    private final MatrixService matrixService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<MatrixResponse>>> getAllMatrices() {
        List<MatrixResponse> resp = matrixService.getAll();
        return ResponseEntity.ok(ApiResponse.success(resp, "All matrices retrieved successfully"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MatrixResponse>> getMatrixById(@PathVariable long id) {
        MatrixResponse resp = matrixService.findResponseById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Matrix retrieved successfully"));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<MatrixResponse>> createMatrix(@RequestBody MatrixRequest request) {
        MatrixResponse createdMatrix = matrixService.saveMatrix(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(createdMatrix, "Matrix created successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MatrixResponse>> updateMatrix(@PathVariable long id,
                                                       @RequestBody MatrixRequest request) {
        MatrixResponse resp = matrixService.updateMatrix(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "Matrix updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<MatrixResponse>> deleteMatrix(@PathVariable long id) {
        MatrixResponse resp = matrixService.deleteMatrix(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Matrix deleted successfully"));
    }
}
