package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daoqonq1408.workshopbesql.entity.Subject;

import java.util.List;

public interface SubjectService {
    SubjectResponse getSubject(long id);
    List<SubjectResponse> getAllSubjects();
    SubjectResponse addSubject(SubjectRequest subjectRequest);
    SubjectResponse updateSubject(long id, SubjectRequest subjectRequest);
    SubjectResponse deleteSubject(long id);
    Subject findById(long id);
}
