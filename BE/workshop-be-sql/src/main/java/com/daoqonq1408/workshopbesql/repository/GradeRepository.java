package com.daoqonq1408.workshopbesql.repository;

import com.daoqonq1408.workshopbesql.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByGrade(String name);
}
