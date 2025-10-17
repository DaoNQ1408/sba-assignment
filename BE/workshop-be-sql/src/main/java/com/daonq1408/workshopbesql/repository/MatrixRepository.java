package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.Matrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatrixRepository extends JpaRepository<Matrix, Long> {
    Optional<Matrix> findByTitle(String title);
}
