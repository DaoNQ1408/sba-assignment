package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
