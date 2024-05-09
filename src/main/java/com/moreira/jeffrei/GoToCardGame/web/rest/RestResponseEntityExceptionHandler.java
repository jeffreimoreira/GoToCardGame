package com.moreira.jeffrei.GoToCardGame.web.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * Created by jeffr on 2024-05-07
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {

        HttpStatus status = getStatus(ex);
        String message = status == HttpStatus.INTERNAL_SERVER_ERROR ? "An unexpected error occurred" : ex.getMessage();
        RestExceptionResponseBody body = new RestExceptionResponseBody(message, status.value());
        return handleExceptionInternal(ex, body,
                new HttpHeaders(), status, request);
    }

    private HttpStatus getStatus(RuntimeException ex) {
        if (ex instanceof NoSuchElementException) return HttpStatus.NOT_FOUND;
        if (ex instanceof IllegalArgumentException) return HttpStatus.BAD_REQUEST;
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }


}
