package com.daonq1408.workshopbesql.entity.embedded;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ExamQuestionId implements Serializable {
    private long examId;
    private long questionId;
}
