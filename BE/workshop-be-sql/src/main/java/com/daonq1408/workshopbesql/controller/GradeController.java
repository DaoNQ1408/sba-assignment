package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.GradeRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.GradeResponse;
import com.daonq1408.workshopbesql.service.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<GradeResponse>>> getAllGrades() {
        List<GradeResponse> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(ApiResponse.success(grades, "All grades retrieved"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GradeResponse>> getGradeById(@PathVariable long id) {
        GradeResponse grade = gradeService.getGradeById(id);
        return ResponseEntity.ok(ApiResponse.success(grade, "Grade retrieved"));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<GradeResponse>> addGrade(@Valid @RequestBody GradeRequest request) {
        GradeResponse grade = gradeService.addGrade(request);
        return ResponseEntity.ok(ApiResponse.success(grade, "Grade added successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<GradeResponse>> updateGrade(@PathVariable long id,
                                                                  @Valid @RequestBody GradeRequest request) {
        GradeResponse grade = gradeService.updateGrade(id, request);
        return ResponseEntity.ok(ApiResponse.success(grade, "Grade updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<GradeResponse>> deleteGrade(@PathVariable long id) {
        GradeResponse grade = gradeService.deleteGrade(id);
        return ResponseEntity.ok(ApiResponse.success(grade, "Grade deleted successfully"));
    }
}
