package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.UserRequest;
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
    public ResponseEntity<List<UserResponse>> getAllTeachers() {
        return ResponseEntity.ok(userService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getTeacherById(@PathVariable long id) {
        return ResponseEntity.ok(userService.findResponseById(id));
    }


    @PostMapping
    public ResponseEntity<UserResponse> createTeacher(@RequestBody UserRequest request) {
        UserResponse createdTeacher = userService.saveTeacher(request);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateTeacher(@PathVariable long id,
                                                      @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateTeacher(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteTeacher(@PathVariable long id) {
        return ResponseEntity.ok(userService.deleteTeacher(id));
    }
}
