package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.MatrixLessonRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.MatrixLessonResponse;
import com.daonq1408.workshopbesql.service.MatrixLessonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matrix-lessons")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class MatrixLessonController {

    private final MatrixLessonService matrixLessonService;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<MatrixLessonResponse>>> getAll() {
        List<MatrixLessonResponse> resp = matrixLessonService.getAll();
        return ResponseEntity.ok(ApiResponse.success(resp, "All matrix lessons retrieved successfully"));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<MatrixLessonResponse>> getById(@PathVariable long id) {
        MatrixLessonResponse resp = matrixLessonService.findResponseById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "MatrixLesson retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<MatrixLessonResponse>> create(@RequestBody MatrixLessonRequest request) {
        MatrixLessonResponse resp = matrixLessonService.saveMatrixLesson(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(resp, "MatrixLesson created successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<MatrixLessonResponse>> update(@PathVariable long id,
                                       @RequestBody MatrixLessonRequest request) {
        MatrixLessonResponse resp = matrixLessonService.updateMatrixLesson(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "MatrixLesson updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<MatrixLessonResponse>> delete(@PathVariable long id) {
        MatrixLessonResponse resp = matrixLessonService.deleteMatrixLesson(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "MatrixLesson deleted successfully"));
    }
}
