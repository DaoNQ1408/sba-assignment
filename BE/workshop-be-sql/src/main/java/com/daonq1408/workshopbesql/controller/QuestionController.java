package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.QuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.QuestionResponse;
import com.daonq1408.workshopbesql.service.QuestionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class QuestionController {

    private final QuestionService questionService;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<QuestionResponse>>> getAllQuestions() {
        List<QuestionResponse> resp = questionService.findAllQuestions();
        return ResponseEntity.ok(ApiResponse.success(resp, "All questions retrieved successfully"));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<QuestionResponse>> getQuestionById(@PathVariable long id) {
        QuestionResponse resp = questionService.findResponseById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Question retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<QuestionResponse>> createQuestion(@RequestBody QuestionRequest request) {
        QuestionResponse createdQuestion = questionService.saveQuestion(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(createdQuestion, "Question created successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<QuestionResponse>> updateQuestion(@PathVariable long id,
                                                           @RequestBody QuestionRequest request) {
        QuestionResponse resp = questionService.updateQuestion(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "Question updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<QuestionResponse>> deleteQuestion(@PathVariable long id) {
        QuestionResponse resp = questionService.deleteQuestion(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Question deleted successfully"));
    }
}
