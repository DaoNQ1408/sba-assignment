package com.daoqonq1408.workshopbesql.repository;

import com.daoqonq1408.workshopbesql.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByGrade(String name);
}
