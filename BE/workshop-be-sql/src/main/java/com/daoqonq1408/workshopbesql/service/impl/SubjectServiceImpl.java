package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daoqonq1408.workshopbesql.entity.Subject;
import com.daoqonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daoqonq1408.workshopbesql.repository.SubjectRepository;
import com.daoqonq1408.workshopbesql.service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectResponse getSubject(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }

    @Override
    public List<SubjectResponse> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subject -> SubjectResponse.builder()
                        .id(subject.getId())
                        .name(subject.getName())
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public SubjectResponse addSubject(SubjectRequest request) {
        subjectRepository.findByName(request.getName()).ifPresent(subject -> {
            throw new DuplicateObjectException("Subject already exists with name: " + request.getName());
        });

        Subject subject = subjectRepository.save(new Subject(request.getName()));
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }


    @Override
    @Transactional
    public SubjectResponse updateSubject(long id, SubjectRequest subjectRequest) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));
        // update
        subject.setName(subjectRequest.getName());
        Subject updatedSubject = subjectRepository.save(subject);

        return SubjectResponse.builder()
                .id(updatedSubject.getId())
                .name(updatedSubject.getName())
                .build();
    }

    @Override
    @Transactional
    public SubjectResponse deleteSubject(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + id));

        SubjectResponse response = SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();

        subjectRepository.delete(subject);

        return response;
    }
}
