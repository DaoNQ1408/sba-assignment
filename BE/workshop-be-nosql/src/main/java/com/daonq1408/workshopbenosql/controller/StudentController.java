package com.daonq1408.workshopbenosql.controller;

import com.daonq1408.workshopbenosql.model.Student;
import com.daonq1408.workshopbenosql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public ResponseEntity<?> addStudent(@RequestParam String name) {
        return new ResponseEntity<>(studentService.addStudent(name), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
