package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Long> {
    List<ExamQuestion> findByExamId(Long examId);
    Boolean existsByExamIdAndQuestionId(Long examId, Long questionId);
}
