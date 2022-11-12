package com.spring.crud.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseStatusExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
    public static final String ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM = "Issue during Processing request, Please contact Application team";

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public static final ResponseEntity<ExceptionResponse> exceptionHandler(NullPointerException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
        exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        logError(ex,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalAccessException.class)
    public static final ResponseEntity<ExceptionResponse> exceptionHandler(IllegalAccessException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage("Access issue, please contact Application team");
        exceptionResponse.setStatusCode(HttpStatus.FORBIDDEN);
        logError(ex,HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public static final ResponseEntity<ExceptionResponse> exceptionHandler(RuntimeException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
        exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        logError(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public static final ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
        exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        logError(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static void logError(Exception exception, HttpStatus statusCode){
        log.error("Exception Cause Message : {}", exception.getMessage());
        log.error("Exception Localised Message : {}", exception.getLocalizedMessage());
        log.error("Returned Status: {}", statusCode.MULTI_STATUS.value());
    }
}
