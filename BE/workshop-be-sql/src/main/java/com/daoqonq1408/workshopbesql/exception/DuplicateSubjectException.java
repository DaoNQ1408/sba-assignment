package com.daoqonq1408.workshopbesql.exception;

public class DuplicateSubjectException extends RuntimeException {

    public DuplicateSubjectException(String message) {
        super(message);
    }

    public DuplicateSubjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
