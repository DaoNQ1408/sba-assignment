package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.LevelRequest;
import com.daoqonq1408.workshopbesql.dto.response.LevelResponse;
import com.daoqonq1408.workshopbesql.entity.Level;
import com.daoqonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daoqonq1408.workshopbesql.mapper.LevelMapper;
import com.daoqonq1408.workshopbesql.repository.LevelRepository;
import com.daoqonq1408.workshopbesql.service.LevelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;


    @Override
    public LevelResponse getLevelById(long id) {
        return levelMapper.toResponse(findById(id));
    }


    @Override
    public List<LevelResponse> getLevels() {
        return levelRepository
                .findAll()
                .stream()
                .map(levelMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public LevelResponse addLevel(LevelRequest levelRequest) {

        Level level = levelMapper.toEntity(levelRequest);

        return levelMapper.toResponse(levelRepository.save(level));
    }


    @Override
    @Transactional
    public LevelResponse updateLevel(long id, LevelRequest levelRequest) {

        checkLevelExist(levelRequest.getName());

        Level level = findById(id);

        level.setName(levelRequest.getName());

        return levelMapper.toResponse(levelRepository.save(level));
    }


    @Override
    @Transactional
    public LevelResponse deleteLevel(long id) {

        Level level = findById(id);

        levelRepository.delete(level);

        return levelMapper.toResponse(level);
    }


    @Override
    public Level findById(long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No level found with id " +
                                id)
                );
    }

    private void checkLevelExist(String name) {
        levelRepository.findByName(name)
                .ifPresent(level -> {
                    throw new DuplicateObjectException(
                            "Level already exist with the name: " +
                                    name);
                });
    }
}
