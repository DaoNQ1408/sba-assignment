package com.daoqonq1408.workshopbesql.mapper;

import com.daoqonq1408.workshopbesql.dto.request.LevelRequest;
import com.daoqonq1408.workshopbesql.dto.response.LevelResponse;
import com.daoqonq1408.workshopbesql.entity.Level;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    public LevelResponse toResponse(Level level) {
        return LevelResponse.builder()
                .id(level.getId())
                .name(level.getName())
                .build();
    }


    public Level toEntity(LevelRequest levelRequest) {
        return Level.builder()
                .name(levelRequest.getName())
                .build();
    }
}
