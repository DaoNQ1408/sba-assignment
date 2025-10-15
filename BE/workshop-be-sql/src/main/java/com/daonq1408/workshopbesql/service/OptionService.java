package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;

import java.util.List;

public interface OptionService {
    Option findById(long optionId);
    OptionResponse getById(long optionId);
    List<OptionResponse> getAllOptions();
    OptionResponse saveOption(OptionRequest optionRequest);
    OptionResponse updateOption(long optionId, OptionRequest optionRequest);
    OptionResponse deleteOption(long optionId);
}
