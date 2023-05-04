package io.github.eello.nnz.common.controller;

import io.github.eello.nnz.common.exception.CustomException;
import io.github.eello.nnz.common.exception.ErrorResponse;
import io.github.eello.nnz.common.notification.NotificationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestControllerAdvice
public class ControllerAdvisor {

    private final NotificationManager notificationManager;

    public ControllerAdvisor(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        notificationManager.sendNotification(e, requestUrl, getParams(request));

        HttpStatus status;
        if (e.getStatus() != null) {
            status = e.getStatus();
        } else {
            status = e.getErrorCode().getStatus();
        }

        return ResponseEntity.status(status).body(ErrorResponse.of(e.getErrorCode(), requestUrl));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        notificationManager.sendNotification(e, requestUrl, getParams(request));

        return ResponseEntity.internalServerError().body(
                new ErrorResponse("INTERNAL_SERVER_ERROR", e.getMessage(), requestUrl)
        );
    }

    private String getParams(HttpServletRequest request) {
        StringBuilder params = new StringBuilder();
        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            params.append("- ").append(key).append(" : ").append(request.getParameter(key)).append('\n');
        }

        return params.toString();
    }
}
