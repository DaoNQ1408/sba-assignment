package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import com.daonq1408.workshopbesql.entity.Level;

import java.util.List;

public interface LevelService {
    LevelResponse getLevelById(long id);
    List<LevelResponse> getLevels();
    LevelResponse saveLevel(LevelRequest levelRequest);
    LevelResponse updateLevel(long id, LevelRequest levelRequest);
    LevelResponse deleteLevel(long id);
    Level findById(long id);
}
