package com.daonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatrixResponse {
    private long id;
    private String title;
    private long teacherId;
    private LocalDateTime createdAt;
}
