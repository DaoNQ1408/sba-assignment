package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.UserRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.UserResponse;
import com.daonq1408.workshopbesql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllTeachers() {
        List<UserResponse> resp = userService.getAll();
        return ResponseEntity.ok(ApiResponse.success(resp, "All teachers retrieved successfully"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getTeacherById(@PathVariable long id) {
        UserResponse resp = userService.findResponseById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Teacher retrieved successfully"));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createTeacher(@RequestBody UserRequest request) {
        UserResponse created = userService.saveTeacher(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "Teacher created successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateTeacher(@PathVariable long id,
                                                      @RequestBody UserRequest request) {
        UserResponse resp = userService.updateTeacher(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "Teacher updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> deleteTeacher(@PathVariable long id) {
        UserResponse resp = userService.deleteTeacher(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Teacher deleted successfully"));
    }
}
