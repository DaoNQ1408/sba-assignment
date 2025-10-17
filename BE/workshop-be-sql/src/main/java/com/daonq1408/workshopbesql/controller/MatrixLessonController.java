package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.MatrixLessonRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixLessonResponse;
import com.daonq1408.workshopbesql.service.MatrixLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matrix-lessons")
@RequiredArgsConstructor
public class MatrixLessonController {

    private final MatrixLessonService matrixLessonService;


    @GetMapping
    public List<MatrixLessonResponse> getAll() {
        return matrixLessonService.getAll();
    }


    @GetMapping("/{id}")
    public MatrixLessonResponse getById(@PathVariable long id) {
        return matrixLessonService.findResponseById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatrixLessonResponse create(@RequestBody MatrixLessonRequest request) {
        return matrixLessonService.saveMatrixLesson(request);
    }


    @PutMapping("/{id}")
    public MatrixLessonResponse update(@PathVariable long id,
                                       @RequestBody MatrixLessonRequest request) {
        return matrixLessonService.updateMatrixLesson(id, request);
    }


    @DeleteMapping("/{id}")
    public MatrixLessonResponse delete(@PathVariable long id) {
        return matrixLessonService.deleteMatrixLesson(id);
    }
}
