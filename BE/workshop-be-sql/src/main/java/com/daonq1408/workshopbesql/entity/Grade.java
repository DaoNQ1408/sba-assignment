package com.daonq1408.workshopbesql.entity;

import com.daonq1408.workshopbesql.dto.response.GradeResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String grade;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Lesson> lessons;
}
