package com.daonq1408.workshopbesql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionRequest {
    private String option;
    private boolean isTrue;
    private long questionId;
}
