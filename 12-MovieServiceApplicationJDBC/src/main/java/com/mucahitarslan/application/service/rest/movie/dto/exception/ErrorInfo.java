package com.mucahitarslan.application.service.rest.movie.dto.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public class ErrorInfo {
    private String message;
    private LocalDateTime localDateTime;
    private Object data;

    public ErrorInfo(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
