package com.daonq1408.workshopbenosql.repository;

import com.daonq1408.workshopbenosql.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
