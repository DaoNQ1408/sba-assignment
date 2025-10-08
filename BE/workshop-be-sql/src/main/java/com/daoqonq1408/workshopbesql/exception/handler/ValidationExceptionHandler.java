package com.daoqonq1408.workshopbesql.exception.handler;

import com.daoqonq1408.workshopbesql.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        err -> err.getField(),
                        err -> err.getDefaultMessage()
                ));
        ApiResponse<Map<String, String>> response = ApiResponse.<Map<String, String>>builder()
                .status("error")
                .data(errors)
                .message("Validation failed")
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
