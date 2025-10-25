package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.LessonRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.LessonResponse;
import com.daonq1408.workshopbesql.service.LessonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class LessonController {

    private final LessonService lessonService;


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<LessonResponse>> getLessonById(@PathVariable long id) {
        LessonResponse response = lessonService.findLessonById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Lesson retrieved successfully"));
    }


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<LessonResponse>>> getAllLessons() {
        List<LessonResponse> subjects = lessonService.getAllLessons();
        return ResponseEntity.ok(ApiResponse.success(subjects, "All lessons retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LessonResponse>> addLesson(@Valid @RequestBody LessonRequest request) {
        LessonResponse response = lessonService.saveLesson(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Lesson added successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LessonResponse>> updateLesson(@PathVariable long id,
                                                                      @Valid @RequestBody LessonRequest request) {
        LessonResponse response = lessonService.updateLesson(id, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Lesson updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LessonResponse>> deleteLesson(@PathVariable long id) {
        LessonResponse response = lessonService.deleteLesson(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Lesson deleted successfully"));
    }
}
