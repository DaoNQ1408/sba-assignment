package com.daoqonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Grade(String grade, Subject subject) {
        this.grade = grade;
        this.subject = subject;
    }
}
