package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private long id;

    @Column(name = "option_text", nullable = false, length = 255)
    private String option;

    @Column(name = "is_true", nullable = false)
    private boolean isTrue;
}
