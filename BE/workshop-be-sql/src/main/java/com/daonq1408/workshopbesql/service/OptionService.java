package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.entity.Option;

import java.util.List;

public interface OptionService {
    Option findById(long optionId);
    OptionResponse getById(long optionId);
    List<OptionResponse> getAllOptions();
    OptionResponse save(OptionRequest optionRequest);
    OptionResponse update(long optionId, OptionRequest optionRequest);
    OptionResponse delete(long optionId);
}
