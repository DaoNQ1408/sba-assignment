package com.daoqonq1408.workshopbesql.controller;

import com.daoqonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daoqonq1408.workshopbesql.dto.response.ApiResponse;
import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> getSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.getSubject(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject retrieved successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> getAllSubjects() {
        List<SubjectResponse> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(ApiResponse.success(subjects, "All subjects retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> addSubject(@Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.addSubject(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject added successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> updateSubject(@PathVariable long id,
                                                                      @Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.updateSubject(id, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.deleteSubject(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject deleted successfully"));
    }
}
