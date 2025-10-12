package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "question_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_type_id")
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    private List<MatrixLesson> matrixLessons;
}
