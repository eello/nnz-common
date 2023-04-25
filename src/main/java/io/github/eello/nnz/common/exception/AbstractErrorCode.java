package io.github.eello.nnz.common.exception;

import org.springframework.http.HttpStatus;

public interface AbstractErrorCode {

    String getCode();
    String getMessage();
    HttpStatus getStatus();
}
