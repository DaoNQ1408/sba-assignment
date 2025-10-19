package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exams")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "duration_minutes", nullable = false)
    @Min(value = 0)
    private int durationMinutes;

    @ManyToOne
    @JoinColumn(name = "matrix_id", nullable = false)
    private Matrix matrix;
}
