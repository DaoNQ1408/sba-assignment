package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.LevelRequest;
import com.daoqonq1408.workshopbesql.dto.response.LevelResponse;
import com.daoqonq1408.workshopbesql.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    @Override
    public LevelResponse getLevel(long id) {
        return null;
    }

    @Override
    public List<LevelResponse> getLevels() {
        return List.of();
    }

    @Override
    public LevelResponse addLevel(LevelRequest level) {
        return null;
    }

    @Override
    public LevelResponse updateLevel(long id, LevelRequest level) {
        return null;
    }

    @Override
    public LevelResponse deleteLevel(long id) {
        return null;
    }
}
