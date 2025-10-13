package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;


    @GetMapping
    public ResponseEntity<List<ExamResponse>> getAllExams() {
        return ResponseEntity.ok(examService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ExamResponse> getExamById(@PathVariable long id) {
        return ResponseEntity.ok(examService.getById(id));
    }


    @PostMapping
    public ResponseEntity<ExamResponse> createExam(@RequestBody ExamRequest request) {
        ExamResponse createdExam = examService.save(request);
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ExamResponse> updateExam(@PathVariable long id,
                                                   @RequestBody ExamRequest request) {
        return ResponseEntity.ok(examService.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ExamResponse> deleteExam(@PathVariable long id) {
        return ResponseEntity.ok(examService.delete(id));
    }
}
