package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.TeacherRequest;
import com.daonq1408.workshopbesql.dto.response.TeacherResponse;
import com.daonq1408.workshopbesql.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.findResponseById(id));
    }


    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody TeacherRequest request) {
        TeacherResponse createdTeacher = teacherService.saveTeacher(request);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable long id,
                                                         @RequestBody TeacherRequest request) {
        return ResponseEntity.ok(teacherService.updateTeacher(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherResponse> deleteTeacher(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
