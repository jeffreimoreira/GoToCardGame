package com.moreira.jeffrei.GoToCardGame.web.rest;

/**
 * Created by jeffr on 2024-05-07
 */
public class RestExceptionResponseBody {
    private final String message;
    private final Integer Status;

    public RestExceptionResponseBody(String message, Integer status) {
        this.message = message;
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return Status;
    }
}
