package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.GradeRequest;
import com.daonq1408.workshopbesql.dto.response.GradeResponse;
import com.daonq1408.workshopbesql.entity.Grade;

import java.util.List;

public interface GradeService {
    GradeResponse saveGrade(GradeRequest gradeRequest);
    GradeResponse updateGrade(long id, GradeRequest gradeRequest);
    GradeResponse deleteGrade(long id);
    List<GradeResponse> getAllGrades();
    GradeResponse getGradeById(long id);
    Grade findById(long id);
}
