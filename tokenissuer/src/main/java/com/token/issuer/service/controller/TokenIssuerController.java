package com.token.issuer.service.controller;

import com.netflix.discovery.converters.Auto;
import com.token.issuer.service.exceptionshandling.exceptions.InvalidToken;
import com.token.issuer.service.service.TokenService;
import com.token.issuer.service.service.tokenverifier.TokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("tokenmanager")
public class TokenIssuerController {
    TokenVerifier googleTokenVerifier;
    @Autowired
    TokenService tokenService;
    TokenIssuerController(TokenVerifier tokenVerifier){
    googleTokenVerifier = tokenVerifier;
    }
    @GetMapping("/token")
    public String getToken(@RequestParam("token") String token) throws Exception {
        if (googleTokenVerifier.verifyToken(token) == true) {
            return tokenService.getToken("trialuser");
        } else {
            throw new InvalidToken("InvadilToken");
        }
    }
        @PostMapping("/verify")
        public boolean verify(@RequestParam("access-token") String token) throws Exception {
            return tokenService.verifyToken(token).equals("trialuser");
        }
        @PostMapping("/verifygoogletoken")
        public boolean verifygoogle(@RequestParam("access-token") String token) throws Exception {
            return googleTokenVerifier.verifyToken(token);
        }

}
