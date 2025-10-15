package com.daonq1408.workshopbesql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private String question;
    private long lessonId;
    private long levelId;
    private long questionTypeId;
}
