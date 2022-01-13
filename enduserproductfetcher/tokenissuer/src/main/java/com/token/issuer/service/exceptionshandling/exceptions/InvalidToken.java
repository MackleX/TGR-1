package com.token.issuer.service.exceptionshandling.exceptions;

import lombok.Getter;

@Getter
public class InvalidToken extends RuntimeException {
    private String customErrorMessage;

    public InvalidToken(String customErrorMessage) {
        super();
        this.customErrorMessage = customErrorMessage;
    }
}
