package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.dto.request.LevelRequest;
import com.daoqonq1408.workshopbesql.dto.response.LevelResponse;

import java.util.List;

public interface LevelService {
    LevelResponse getLevel(long id);
    List<LevelResponse> getLevels();
    LevelResponse addLevel(LevelRequest level);
    LevelResponse updateLevel(long id, LevelRequest level);
    LevelResponse deleteLevel(long id);
}
