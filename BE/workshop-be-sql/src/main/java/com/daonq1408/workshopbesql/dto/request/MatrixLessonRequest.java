package com.daonq1408.workshopbesql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatrixLessonRequest {
    private long matrixId;
    private long lessonId;
    private long levelId;
    private long questionTypeId;
    private int questionNum;
}
