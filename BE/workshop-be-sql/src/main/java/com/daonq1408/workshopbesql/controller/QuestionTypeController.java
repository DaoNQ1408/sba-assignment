package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.QuestionTypeResponse;
import com.daonq1408.workshopbesql.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question-types")
@RequiredArgsConstructor
public class QuestionTypeController {

    private final QuestionTypeService questionTypeService;


    @GetMapping("")
    public ResponseEntity<ApiResponse<List<QuestionTypeResponse>>> getAllQuestionTypes() {
        List<QuestionTypeResponse> resp = questionTypeService.findAll();
        return ResponseEntity.ok(ApiResponse.success(resp, "All question types retrieved successfully"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QuestionTypeResponse>> getQuestionTypeById(@PathVariable long id) {
        QuestionTypeResponse resp = questionTypeService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "QuestionType retrieved successfully"));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<QuestionTypeResponse>> createQuestionType(@RequestBody QuestionTypeRequest request) {
        QuestionTypeResponse created = questionTypeService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "QuestionType created successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<QuestionTypeResponse>> updateQuestionType(@PathVariable long id,
                                                                   @RequestBody QuestionTypeRequest request) {
        QuestionTypeResponse resp = questionTypeService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "QuestionType updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<QuestionTypeResponse>> deleteQuestionType(@PathVariable long id) {
        QuestionTypeResponse resp = questionTypeService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "QuestionType deleted successfully"));
    }
}
