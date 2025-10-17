package com.daonq1408.workshopbesql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamQuestionRequest {
    private long examId;
    private long questionId;
    private float pointPercent;
}
