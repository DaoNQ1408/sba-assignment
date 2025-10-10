package com.daoqonq1408.workshopbesql.entity;

import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Subject(String name) {
        this.name = name;
    }

    public SubjectResponse toResponse() {
        return SubjectResponse.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
