package io.github.eello.nnz.common.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ErrorCode {

    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
