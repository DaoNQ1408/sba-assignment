package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.TeacherRequest;
import com.daonq1408.workshopbesql.dto.response.TeacherResponse;
import com.daonq1408.workshopbesql.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findById(long teacherId);
    TeacherResponse findResponseById(long teacherId);
    List<TeacherResponse> getAll();
    TeacherResponse saveTeacher(TeacherRequest teacherRequest);
    TeacherResponse updateTeacher(long teacherId, TeacherRequest teacherRequest);
    TeacherResponse deleteTeacher(long teacherId);
}
