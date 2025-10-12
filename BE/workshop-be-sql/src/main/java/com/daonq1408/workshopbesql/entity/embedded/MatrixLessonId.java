package com.daonq1408.workshopbesql.entity.embedded;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MatrixLessonId implements Serializable {
    private long matrixId;
    private long lessonId;
    private long levelId;
    private long questionTypeId;
}
