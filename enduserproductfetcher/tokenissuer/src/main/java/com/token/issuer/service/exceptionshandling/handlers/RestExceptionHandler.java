package com.token.issuer.service.exceptionshandling.handlers;

import com.token.issuer.service.exceptionshandling.exceptions.ApiRequestException;
import com.token.issuer.service.exceptionshandling.exceptions.InvalidToken;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request:";
        return buildResponseEntity(new ApiRequestException(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiRequestException apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


    @ExceptionHandler(InvalidToken.class)
    protected ResponseEntity<Object> handleEntityNotFound(InvalidToken ex) {
        ApiRequestException apiError = new ApiRequestException(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getCustomErrorMessage());
        apiError.setDebugMessage("Please enter a valid token");
        return buildResponseEntity(apiError);
    }

}

