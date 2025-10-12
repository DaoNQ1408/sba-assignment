package com.daonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionResponse {
    private long optionId;
    private String option;
    private boolean isTrue;
    private long questionId;
}
