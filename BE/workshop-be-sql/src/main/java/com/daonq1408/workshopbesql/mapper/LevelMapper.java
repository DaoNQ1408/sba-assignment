package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import com.daonq1408.workshopbesql.entity.Level;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LevelMapper {

    LevelResponse toResponse(Level level);


    @Mapping(target = "id", ignore = true)
    Level toEntity(LevelRequest levelRequest);


    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Level level,
                                          LevelRequest levelRequest);
}
