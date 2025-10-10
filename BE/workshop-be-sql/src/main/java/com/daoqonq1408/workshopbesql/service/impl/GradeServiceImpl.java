package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.GradeRequest;
import com.daoqonq1408.workshopbesql.dto.response.GradeResponse;
import com.daoqonq1408.workshopbesql.entity.Grade;
import com.daoqonq1408.workshopbesql.entity.Subject;
import com.daoqonq1408.workshopbesql.repository.GradeRepository;
import com.daoqonq1408.workshopbesql.repository.SubjectRepository;
import com.daoqonq1408.workshopbesql.service.GradeService;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    public GradeServiceImpl(GradeRepository gradeRepository,
                            SubjectRepository subjectRepository,
                            SubjectService subjectService) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
    }

    @Override
    @Transactional
    public GradeResponse addGrade(GradeRequest gradeRequest) {
        // save new grade record
        Grade grade = gradeRepository.save(new Grade(
                gradeRequest.getGrade(),
                subjectService.findById(gradeRequest.getSubjectId()))
        );

        return grade.toResponse();
    }

    @Override
    @Transactional
    public GradeResponse updateGrade(long id, GradeRequest gradeRequest) {

        Grade grade = findById(id);

        Subject subject = subjectService.findById(gradeRequest.getSubjectId());

        grade.setGrade(gradeRequest.getGrade());
        grade.setSubject(subject);

        Grade updatedGrade = gradeRepository.save(grade);

        return updatedGrade.toResponse();
    }

    @Override
    @Transactional
    public GradeResponse deleteGrade(long id) {

        Grade grade = findById(id);

        gradeRepository.delete(grade);

        return grade.toResponse();
    }

    @Override
    public List<GradeResponse> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(Grade::toResponse)
                .toList();
    }

    @Override
    public GradeResponse getGradeById(long id) {

        Grade grade = findById(id);

        return grade.toResponse();
    }

    @Override
    public Grade findById(long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find grade with id: " + id));
    }
}
