package com.daonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatrixLessonResponse {
    private long matrixId;
    private long lessonId;
    private long levelId;
    private long questionTypeId;
    private int questionNum;
}
