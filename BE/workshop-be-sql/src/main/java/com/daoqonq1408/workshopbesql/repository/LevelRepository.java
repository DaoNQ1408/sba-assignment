package com.daoqonq1408.workshopbesql.repository;

import com.daoqonq1408.workshopbesql.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByName(String name);
}
