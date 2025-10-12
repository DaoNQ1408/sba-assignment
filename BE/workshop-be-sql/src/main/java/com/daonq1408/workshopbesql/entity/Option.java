package com.daonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "options")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private long id;

    @Column(name = "option_text", nullable = false, length = 255)
    private String option;

    @Column(name = "is_true", nullable = false)
    private boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
