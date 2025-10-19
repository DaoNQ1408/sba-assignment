package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.MatrixRequest;
import com.daonq1408.workshopbesql.dto.response.MatrixResponse;
import com.daonq1408.workshopbesql.entity.Matrix;
import com.daonq1408.workshopbesql.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {UserService.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatrixMapper {

    @Mapping(target = "userId", source = "user.id")
    MatrixResponse toResponse(Matrix matrix);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "userId")
    Matrix toEntity(MatrixRequest matrixRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "userId")
    void updateEntityFromRequest(@MappingTarget Matrix matrix,
                                 MatrixRequest matrixRequest);
}
