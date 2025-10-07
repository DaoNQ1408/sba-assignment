package com.daoqonq1408.workshopbesql.entity;

import com.daoqonq1408.workshopbesql.entity.embedded.ExamQuestionId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam_question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamQuestion {

    @EmbeddedId
    private ExamQuestionId id;

    @ManyToOne
    @MapsId("examId")
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "point_percent")
    private float pointPercent;
}
