package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matrix_lesson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatrixLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matrix_lesson_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "matrix_id")
    private Matrix matrix;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;

    @Column(name = "question_num")
    private int questionNum;
}
