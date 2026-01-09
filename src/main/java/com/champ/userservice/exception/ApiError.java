package com.champ.userservice.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Object message;
    private String path;

    public ApiError(int status, String error, Object message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
