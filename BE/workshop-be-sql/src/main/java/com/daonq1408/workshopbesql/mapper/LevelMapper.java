package com.daonq1408.workshopbesql.mapper;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import com.daonq1408.workshopbesql.entity.Level;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LevelMapper {

    LevelResponse toResponse(Level level);


    Level toEntity(LevelRequest levelRequest);
}
