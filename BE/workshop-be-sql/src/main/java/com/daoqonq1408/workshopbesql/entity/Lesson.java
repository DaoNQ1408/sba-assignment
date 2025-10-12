package com.daoqonq1408.workshopbesql.entity;

import com.daoqonq1408.workshopbesql.dto.response.LessonResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "lessons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<MatrixLesson> matrixLessons;

    public Lesson(String title, Grade grade) {
        this.title = title;
        this.grade = grade;
    }

    public LessonResponse toResponse() {
        return LessonResponse.builder()
                .id(this.id)
                .title(this.title)
                .gradeId(this.grade.getId())
                .build();
    }
}
