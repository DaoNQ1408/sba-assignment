package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.MatrixRequest;
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
    public ResponseEntity<List<MatrixResponse>> getAllMatrices() {
        return ResponseEntity.ok(matrixService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<MatrixResponse> getMatrixById(@PathVariable long id) {
        return ResponseEntity.ok(matrixService.findResponseById(id));
    }


    @PostMapping
    public ResponseEntity<MatrixResponse> createMatrix(@RequestBody MatrixRequest request) {
        MatrixResponse createdMatrix = matrixService.saveMatrix(request);
        return new ResponseEntity<>(createdMatrix, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MatrixResponse> updateMatrix(@PathVariable long id,
                                                       @RequestBody MatrixRequest request) {
        return ResponseEntity.ok(matrixService.updateMatrix(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MatrixResponse> deleteMatrix(@PathVariable long id) {
        return ResponseEntity.ok(matrixService.deleteMatrix(id));
    }
}
