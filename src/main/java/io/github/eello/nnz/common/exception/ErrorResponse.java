package io.github.eello.nnz.common.exception;

public class ErrorResponse {

    private String code;
    private String message;
    private String requestUrl;

    public ErrorResponse(String code, String message, String requestUrl) {
        this.code = code;
        this.message = message;
        this.requestUrl = requestUrl;
    }

    public static ErrorResponse of(AbstractErrorCode abstractErrorCode, String requestUrl) {
        return new ErrorResponse(abstractErrorCode.getCode(), abstractErrorCode.getMessage(), requestUrl);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
