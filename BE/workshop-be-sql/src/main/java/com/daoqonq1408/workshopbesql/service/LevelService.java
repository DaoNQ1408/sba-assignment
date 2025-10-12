package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.dto.request.LevelRequest;
import com.daoqonq1408.workshopbesql.dto.response.LevelResponse;
import com.daoqonq1408.workshopbesql.entity.Level;

import java.util.List;

public interface LevelService {
    LevelResponse getLevelById(long id);
    List<LevelResponse> getLevels();
    LevelResponse addLevel(LevelRequest levelRequest);
    LevelResponse updateLevel(long id, LevelRequest levelRequest);
    LevelResponse deleteLevel(long id);
    Level findById(long id);
}
