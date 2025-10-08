package com.daoqonq1408.workshopbesql.exception.handler;

import com.daoqonq1408.workshopbesql.dto.response.ApiResponse;
import com.daoqonq1408.workshopbesql.exception.DuplicateSubjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateSubjectExceptionHandler {

    @ExceptionHandler(DuplicateSubjectException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateSubject(DuplicateSubjectException ex) {
        ApiResponse<Object> response = ApiResponse.builder()
                .status("error")
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
