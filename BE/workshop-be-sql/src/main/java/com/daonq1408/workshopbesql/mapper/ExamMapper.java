package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.ExamRequest;
import com.daonq1408.workshopbesql.dto.response.ExamResponse;
import com.daonq1408.workshopbesql.entity.Exam;

import com.daonq1408.workshopbesql.service.MatrixService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {MatrixService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExamMapper {

    @Mapping(source = "matrix.id", target = "matrixId")
    ExamResponse toResponse(Exam exam);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "matrixId", target = "matrix")
    Exam toEntity(ExamRequest examRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "matrixId", target = "matrix")
    void updateEntityFromRequest(@MappingTarget Exam exam,
                                 ExamRequest examRequest);
}
