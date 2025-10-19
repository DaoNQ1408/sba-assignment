package com.daonq1408.workshopbesql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatrixRequest {
    private String title;
    private long userId;
}
