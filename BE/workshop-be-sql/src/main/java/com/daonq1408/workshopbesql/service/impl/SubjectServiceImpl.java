package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daonq1408.workshopbesql.entity.Subject;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.SubjectMapper;
import com.daonq1408.workshopbesql.repository.SubjectRepository;
import com.daonq1408.workshopbesql.service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectResponse getSubject(long id) {
        return subjectMapper.toResponse(findById(id));
    }


    @Override
    public List<SubjectResponse> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public SubjectResponse addSubject(SubjectRequest request) {

        checkNameExist(request.getName());

        Subject subject = subjectRepository.save(subjectMapper.toEntity(request));

        return subjectMapper.toResponse(subject);
    }


    @Override
    @Transactional
    public SubjectResponse updateSubject(long id, SubjectRequest subjectRequest) {

        Subject subject = findById(id);

        subject.setName(subjectRequest.getName());
        Subject updatedSubject = subjectRepository.save(subject);

        return subjectMapper.toResponse(updatedSubject);
    }


    @Override
    @Transactional
    public SubjectResponse deleteSubject(long id) {

        Subject subject = findById(id);

        subjectRepository.delete(subject);

        return subjectMapper.toResponse(subject);
    }


    @Override
    public Subject findById(long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Subject not found with id: " +
                                id)
                );
    }


    public void checkNameExist(String name) {
        subjectRepository.findByName(name)
                .ifPresent(subject -> {
                    throw new DuplicateObjectException(
                            "Subject already exists with name: " +
                                    name);
                });
    }
}
