package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Optional<Exam> findByTitle(String title);
}
