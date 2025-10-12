package com.daonq1408.workshopbesql.entity;

import com.daonq1408.workshopbesql.entity.embedded.MatrixLessonId;
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
    @EmbeddedId
    private MatrixLessonId id;

    @ManyToOne
    @MapsId("matrixId")
    @JoinColumn(name = "matrix_id")
    private Matrix matrix;

    @ManyToOne
    @MapsId("lessonId")
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @MapsId("levelId")
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne
    @MapsId("questionTypeId")
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;

    @Column(name = "question_num")
    private int questionNum;
}
