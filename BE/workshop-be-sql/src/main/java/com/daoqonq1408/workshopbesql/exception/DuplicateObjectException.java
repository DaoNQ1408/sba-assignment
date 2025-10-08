package com.daoqonq1408.workshopbesql.exception;

public class DuplicateObjectException extends RuntimeException {

    public DuplicateObjectException(String message) {
        super(message);
    }

    public DuplicateObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
