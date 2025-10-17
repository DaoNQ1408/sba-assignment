package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.TeacherRequest;
import com.daonq1408.workshopbesql.dto.response.TeacherResponse;
import com.daonq1408.workshopbesql.entity.Teacher;
import com.daonq1408.workshopbesql.mapper.TeacherMapper;
import com.daonq1408.workshopbesql.repository.TeacherRepository;
import com.daonq1408.workshopbesql.service.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    @Override
    public Teacher findById(long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher not found with id " +
                                teacherId)
                );
    }


    @Override
    public TeacherResponse findResponseById(long teacherId) {
        return teacherMapper.toResponse(findById(teacherId));
    }


    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public TeacherResponse saveTeacher(TeacherRequest teacherRequest) {

        Teacher teacher = teacherMapper.toEntity(teacherRequest);

        return teacherMapper.toResponse(teacherRepository.save(teacher));
    }


    @Override
    @Transactional
    public TeacherResponse updateTeacher(long teacherId, TeacherRequest teacherRequest) {

        Teacher teacher = findById(teacherId);

        teacherMapper.updateEntityFromRequest(teacher, teacherRequest);

        Teacher updatedTeacher = teacherRepository.save(teacher);

        return teacherMapper.toResponse(updatedTeacher);
    }


    @Override
    @Transactional
    public TeacherResponse deleteTeacher(long teacherId) {

        Teacher teacher = findById(teacherId);

        teacherRepository.delete(teacher);

        return teacherMapper.toResponse(teacher);
    }
}
