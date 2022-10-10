package com.gmttl.fullstack.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleAPIRequestException(APIRequestException e) {
        // 1. Create JSON payload w exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        APIException apiException = new APIException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }

}
