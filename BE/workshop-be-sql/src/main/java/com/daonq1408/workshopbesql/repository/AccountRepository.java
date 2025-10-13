package com.daonq1408.workshopbesql.repository;

import com.daonq1408.workshopbesql.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByMail(String mail);
}