package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.service.ExamService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ExamController {

    private final ExamService examService;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<ExamResponse>>> getAllExams() {
        List<ExamResponse> exams = examService.getAll();
        return ResponseEntity.ok(ApiResponse.success(exams, "All exams retrieved successfully"));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<ExamResponse>> getExamById(@PathVariable long id) {
        ExamResponse exam = examService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(exam, "Exam retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamResponse>> createExam(@RequestBody ExamRequest request) {
        ExamResponse createdExam = examService.saveExam(request);
        return ResponseEntity.ok(ApiResponse.success(createdExam, "Exam created successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamResponse>> updateExam(@PathVariable long id,
                                                   @RequestBody ExamRequest request) {
        ExamResponse updatedExam = examService.updateExam(id, request);
        return ResponseEntity.ok(ApiResponse.success(updatedExam, "Exam updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamResponse>> deleteExam(@PathVariable long id) {
        ExamResponse deletedExam = examService.deleteExam(id);
        return ResponseEntity.ok(ApiResponse.success(deletedExam, "Exam deleted successfully"));
    }
}
