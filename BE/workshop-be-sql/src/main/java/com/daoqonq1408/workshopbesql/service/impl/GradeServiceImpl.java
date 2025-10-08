package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.GradeRequest;
import com.daoqonq1408.workshopbesql.dto.response.GradeResponse;
import com.daoqonq1408.workshopbesql.entity.Grade;
import com.daoqonq1408.workshopbesql.entity.Subject;
import com.daoqonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daoqonq1408.workshopbesql.repository.GradeRepository;
import com.daoqonq1408.workshopbesql.repository.SubjectRepository;
import com.daoqonq1408.workshopbesql.service.GradeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;

    public GradeServiceImpl(GradeRepository gradeRepository,
                            SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    @Transactional
    public GradeResponse addGrade(GradeRequest gradeRequest) {
        // save new grade record
        Grade grade = gradeRepository.save(new Grade(gradeRequest.getGrade(),
                subjectRepository.findById(gradeRequest.getSubjectId())
                        .orElseThrow(() -> new EntityNotFoundException("Can not find subject with id: " + gradeRequest.getSubjectId()))));

        return GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .subjectId(grade.getSubject().getId())
                .build();
    }

    @Override
    @Transactional
    public GradeResponse updateGrade(long id, GradeRequest gradeRequest) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade not found with id: " + id));

        Subject subject = subjectRepository.findById(gradeRequest.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Subject not found with id: " + gradeRequest.getSubjectId()));

        grade.setGrade(gradeRequest.getGrade());
        grade.setSubject(subject);

        Grade updatedGrade = gradeRepository.save(grade);

        return GradeResponse.builder()
                .id(updatedGrade.getId())
                .grade(updatedGrade.getGrade())
                .subjectId(updatedGrade.getSubject().getId())
                .build();
    }

    @Override
    @Transactional
    public GradeResponse deleteGrade(long id) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find grade with id: " + id));

        GradeResponse gradeResponse = GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .subjectId(grade.getSubject().getId())
                .build();

        gradeRepository.delete(grade);

        return gradeResponse;
    }

    @Override
    public List<GradeResponse> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(grade -> GradeResponse.builder()
                        .id(grade.getId())
                        .subjectId(grade.getSubject().getId())
                        .grade(grade.getGrade())
                        .build())
                .toList();
    }

    @Override
    public GradeResponse getGradeById(long id) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find grade with id: " + id));

        return GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .subjectId(grade.getSubject().getId())
                .build();
    }
}
