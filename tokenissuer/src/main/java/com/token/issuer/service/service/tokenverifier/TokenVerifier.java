package com.token.issuer.service.service.tokenverifier;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface TokenVerifier {

    public TokenVerifierBuilder tokenVerifierBuilder();

    public boolean verifyToken(String token) throws GeneralSecurityException, IOException;

}
