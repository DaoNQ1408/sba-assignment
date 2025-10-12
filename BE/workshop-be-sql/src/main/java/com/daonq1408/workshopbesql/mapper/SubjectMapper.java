package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daonq1408.workshopbesql.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }


    public Subject toEntity(SubjectRequest subjectRequest) {
        return Subject.builder()
                .name(subjectRequest.getName())
                .build();
    }
}
