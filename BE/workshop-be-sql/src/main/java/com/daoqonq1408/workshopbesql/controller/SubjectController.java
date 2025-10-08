package com.daoqonq1408.workshopbesql.controller;

import com.daoqonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daoqonq1408.workshopbesql.dto.response.ApiResponse;
import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import jakarta.validation.Valid;
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
    public ApiResponse<SubjectResponse> getSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.getSubject(id);
        return ApiResponse.<SubjectResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    @GetMapping("")
    public ApiResponse<List<SubjectResponse>> getAllSubjects() {
        List<SubjectResponse> subjects = subjectService.getAllSubjects();
        return ApiResponse.<List<SubjectResponse>>builder()
                .status("success")
                .data(subjects)
                .build();
    }

    @PostMapping("")
    public ApiResponse<SubjectResponse> addSubject(@Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.addSubject(request);
        return ApiResponse.<SubjectResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<SubjectResponse> updateSubject(@PathVariable long id,
                                                      @Valid @RequestBody SubjectRequest request) {
        SubjectResponse response = subjectService.updateSubject(id, request);
        return ApiResponse.<SubjectResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<SubjectResponse> deleteSubject(@PathVariable long id) {
        SubjectResponse response = subjectService.deleteSubject(id);
        return ApiResponse.<SubjectResponse>builder()
                .status("success")
                .data(response)
                .build();
    }
}
