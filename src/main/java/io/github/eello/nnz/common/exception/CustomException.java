package io.github.eello.nnz.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
    private HttpStatus status;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, HttpStatus status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
