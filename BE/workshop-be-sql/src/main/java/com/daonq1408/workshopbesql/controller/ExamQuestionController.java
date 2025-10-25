package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.ExamQuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.ExamQuestionResponse;
import com.daonq1408.workshopbesql.service.ExamQuestionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-questions")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ExamQuestionController {

    private final ExamQuestionService examQuestionService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<List<ExamQuestionResponse>>> getAll() {
        List<ExamQuestionResponse> resp = examQuestionService.getAll();
        return ResponseEntity.ok(ApiResponse.success(resp, "All exam questions retrieved successfully"));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<ExamQuestionResponse>> getById(@PathVariable long id) {
        ExamQuestionResponse resp = examQuestionService.findResponseById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "ExamQuestion retrieved successfully"));
    }


    @GetMapping("/exam/{examId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<List<ExamQuestionResponse>>> getByExamId(@PathVariable long examId) {
        List<ExamQuestionResponse> resp = examQuestionService.findByExamId(examId);
        return ResponseEntity.ok(ApiResponse.success(resp, "Exam questions for exam retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamQuestionResponse>> create(@RequestBody ExamQuestionRequest request) {
        ExamQuestionResponse resp = examQuestionService.saveExamQuestion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(resp, "ExamQuestion created successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamQuestionResponse>> update(@PathVariable long id,
                                       @RequestBody ExamQuestionRequest request) {
        ExamQuestionResponse resp = examQuestionService.updateExamQuestion(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "ExamQuestion updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ExamQuestionResponse>> delete(@PathVariable long id) {
        ExamQuestionResponse resp = examQuestionService.deleteExamQuestion(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "ExamQuestion deleted successfully"));
    }
}
