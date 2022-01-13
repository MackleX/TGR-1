package com.token.issuer.service.service.tokenverifier;

public interface TokenVerifierBuilder {
    TokenVerifierBuilder issuer(String issuer);
    TokenVerifierBuilder clientID(String token);
    String getIssuer();
    String getClientID();
    TokenVerifier build();
}
