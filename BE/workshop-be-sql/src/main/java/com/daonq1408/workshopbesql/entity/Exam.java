package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "duration_minutes", nullable = false)
    @Min(value = 0)
    private int durationMinutes;
}
