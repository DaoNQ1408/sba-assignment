package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;
import com.daonq1408.workshopbesql.mapper.OptionMapper;
import com.daonq1408.workshopbesql.repository.OptionRepository;
import com.daonq1408.workshopbesql.service.OptionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final OptionMapper optionMapper;


    @Override
    public Option findById(long optionId) {
        return optionRepository.findById(optionId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Option not found with id " +
                                optionId)
                );
    }


    @Override
    public OptionResponse getById(long optionId) {
        return optionMapper.toResponse(findById(optionId));
    }


    @Override
    public List<OptionResponse> getAllOptions() {
        return optionRepository
                .findAll()
                .stream()
                .map(optionMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public OptionResponse saveOption(OptionRequest optionRequest) {

        Option option = optionMapper.toEntity(optionRequest);
        Option savedOption = optionRepository.save(option);

        return optionMapper.toResponse(savedOption);
    }


    @Override
    @Transactional
    public OptionResponse updateOption(long optionId, OptionRequest optionRequest) {

        Option option = findById(optionId);

        optionMapper.updateEntityFromRequest(option, optionRequest);
        Option updatedOption = optionRepository.save(option);

        return optionMapper.toResponse(updatedOption);
    }


    @Override
    @Transactional
    public OptionResponse deleteOption(long optionId) {

        Option option = findById(optionId);

        optionRepository.delete(option);

        return optionMapper.toResponse(option);
    }
}
