package com.daoqonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private T data;
    private String message;
}
