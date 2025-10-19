package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
