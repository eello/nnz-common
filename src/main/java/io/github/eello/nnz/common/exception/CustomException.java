package io.github.eello.nnz.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private AbstractErrorCode abstractErrorCode;
    private HttpStatus status;

    public CustomException(AbstractErrorCode abstractErrorCode) {
        this.abstractErrorCode = abstractErrorCode;
    }

    public CustomException(AbstractErrorCode abstractErrorCode, HttpStatus status) {
        this.abstractErrorCode = abstractErrorCode;
        this.status = status;
    }

    public AbstractErrorCode getErrorCode() {
        return abstractErrorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
