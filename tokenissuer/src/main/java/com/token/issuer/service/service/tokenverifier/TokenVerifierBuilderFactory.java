package com.token.issuer.service.service.tokenverifier;


import com.token.issuer.service.service.tokenverifier.google.GoogleTokenVerifier;

public class TokenVerifierBuilderFactory{
    public TokenVerifier getTokenVerifier(String issuer) throws Exception {
        if(issuer == "GOOGLE"){
        return new GoogleTokenVerifier(){};
        }else{
            throw new Exception("test");
        }
    }

}
