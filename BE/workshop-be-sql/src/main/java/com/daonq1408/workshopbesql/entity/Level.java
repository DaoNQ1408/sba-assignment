package com.daonq1408.workshopbesql.entity;

import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "levels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<MatrixLesson> matrixLessons;

    public LevelResponse toResponse() {
        return LevelResponse.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
