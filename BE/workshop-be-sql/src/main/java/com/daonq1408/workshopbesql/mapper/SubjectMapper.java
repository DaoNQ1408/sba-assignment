package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.SubjectRequest;
import com.daonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daonq1408.workshopbesql.entity.Subject;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectResponse toResponse(Subject subject);


    Subject toEntity(SubjectRequest subjectRequest);
}
