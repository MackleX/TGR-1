package com.token.issuer.service.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtWrapper {
    private String jwtToken;
    public JwtWrapper(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
