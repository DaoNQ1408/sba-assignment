package com.daonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamResponse {
    private long id;
    private String title;
    private int durationMinutes;
    private long matrixId;
}
