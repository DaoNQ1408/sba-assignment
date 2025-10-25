package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daonq1408.workshopbesql.service.SubjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<SubjectResponse>> getSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.getSubject(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject retrieved successfully"));
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> getAllSubjects() {
        List<SubjectResponse> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(ApiResponse.success(subjects, "All subjects retrieved successfully"));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<SubjectResponse>> addSubject(@Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.addSubject(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject added successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<SubjectResponse>> updateSubject(@PathVariable long id,
                                                                      @Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.updateSubject(id, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.deleteSubject(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Subject deleted successfully"));
    }
}
