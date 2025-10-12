package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.GradeRequest;
import com.daoqonq1408.workshopbesql.dto.response.GradeResponse;
import com.daoqonq1408.workshopbesql.entity.Grade;
import com.daoqonq1408.workshopbesql.entity.Subject;
import com.daoqonq1408.workshopbesql.mapper.GradeMapper;
import com.daoqonq1408.workshopbesql.repository.GradeRepository;
import com.daoqonq1408.workshopbesql.repository.SubjectRepository;
import com.daoqonq1408.workshopbesql.service.GradeService;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final SubjectService subjectService;
    private final GradeMapper gradeMapper;


    @Override
    @Transactional
    public GradeResponse addGrade(GradeRequest gradeRequest) {
        // save new grade record
        Grade grade = gradeRepository.save(new Grade(
                gradeRequest.getGrade(),
                subjectService.findById(gradeRequest.getSubjectId()))
        );

        return gradeMapper.toResponse(grade);
    }


    @Override
    @Transactional
    public GradeResponse updateGrade(long id, GradeRequest gradeRequest) {

        Grade grade = findById(id);

        Subject subject = subjectService.findById(gradeRequest.getSubjectId());

        grade.setGrade(gradeRequest.getGrade());
        grade.setSubject(subject);

        Grade updatedGrade = gradeRepository.save(grade);

        return gradeMapper.toResponse(updatedGrade);
    }


    @Override
    @Transactional
    public GradeResponse deleteGrade(long id) {

        Grade grade = findById(id);

        gradeRepository.delete(grade);

        return gradeMapper.toResponse(grade);
    }


    @Override
    public List<GradeResponse> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(gradeMapper::toResponse)
                .toList();
    }


    @Override
    public GradeResponse getGradeById(long id) {

        Grade grade = findById(id);

        return gradeMapper.toResponse(grade);
    }


    @Override
    public Grade findById(long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find grade with id: " + id));
    }
}
