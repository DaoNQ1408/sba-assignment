package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long id;

    @Column(name = "question", nullable = false, length = 255)
    private String question;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "question_type_id", nullable = false)
    private QuestionType questionType;
}
