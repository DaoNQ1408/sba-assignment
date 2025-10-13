package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.QuestionTypeRequest;
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
    public ResponseEntity<List<QuestionTypeResponse>> getAllQuestionTypes() {
        return ResponseEntity.ok(questionTypeService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionTypeResponse> getQuestionTypeById(@PathVariable long id) {
        return ResponseEntity.ok(questionTypeService.getById(id));
    }


    @PostMapping
    public ResponseEntity<QuestionTypeResponse> createQuestionType(@RequestBody QuestionTypeRequest request) {
        QuestionTypeResponse createdQuestionType = questionTypeService.save(request);
        return new ResponseEntity<>(createdQuestionType, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<QuestionTypeResponse> updateQuestionType(@PathVariable long id,
                                                                   @RequestBody QuestionTypeRequest request) {
        return ResponseEntity.ok(questionTypeService.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<QuestionTypeResponse> deleteQuestionType(@PathVariable long id) {
        return ResponseEntity.ok(questionTypeService.delete(id));
    }
}
