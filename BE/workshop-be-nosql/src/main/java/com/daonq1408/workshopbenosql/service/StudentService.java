package com.daonq1408.workshopbenosql.service;

import com.daonq1408.workshopbenosql.model.Student;
import com.daonq1408.workshopbenosql.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
