package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.ExamQuestionRequest;
import com.daonq1408.workshopbesql.dto.response.ExamQuestionResponse;
import com.daonq1408.workshopbesql.service.ExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-questions")
@RequiredArgsConstructor
public class ExamQuestionController {

    private final ExamQuestionService examQuestionService;

    @GetMapping
    public List<ExamQuestionResponse> getAll() {
        return examQuestionService.getAll();
    }


    @GetMapping("/{id}")
    public ExamQuestionResponse getById(@PathVariable long id) {
        return examQuestionService.findResponseById(id);
    }


    @GetMapping("/exam/{examId}")
    public List<ExamQuestionResponse> getByExamId(@PathVariable long examId) {
        return examQuestionService.findByExamId(examId);
    }


    @PostMapping
    public ExamQuestionResponse create(@RequestBody ExamQuestionRequest request) {
        return examQuestionService.saveExamQuestion(request);
    }


    @PutMapping("/{id}")
    public ExamQuestionResponse update(@PathVariable long id,
                                       @RequestBody ExamQuestionRequest request) {
        return examQuestionService.updateExamQuestion(id, request);
    }


    @DeleteMapping("/{id}")
    public ExamQuestionResponse delete(@PathVariable long id) {
        return examQuestionService.deleteExamQuestion(id);
    }
}
