package com.token.issuer.service.service.tokenverifier.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.token.issuer.service.service.tokenverifier.TokenVerifier;
import com.token.issuer.service.service.tokenverifier.TokenVerifierBuilder;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


public class GoogleTokenVerifier implements TokenVerifier {

    GoogleIdTokenVerifier verifier;

    JsonFactory jsonFactory = GoogleClientDependencies.GsonFactory();
    HttpTransport httpTransport = GoogleClientDependencies.httpTransport();

    public GoogleTokenVerifier() {

    }

    public GoogleTokenVerifier(TokenVerifierBuilder tokenBuilder){
        this.verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
                .setAudience(Collections.singletonList(tokenBuilder.getClientID()))
                .build();

    }



    @Override
    public boolean verifyToken(String token) throws GeneralSecurityException, IOException {
        GoogleIdToken idToken = this.verifier.verify(token);
        return !(idToken == null);
    }

    public TokenVerifierBuilder tokenVerifierBuilder (){
        return new GoogleTokenBuilder();
    }


    public static class GoogleTokenBuilder implements TokenVerifierBuilder {

        private String issuer = "No issuer is set";
        private String clientID = "No ClientID is set";

        GoogleTokenBuilder(){

        }
        @Override
        public TokenVerifierBuilder issuer(String issuer) {
            this.issuer = issuer;
            return this;
        }


        @Override
        public TokenVerifierBuilder clientID(String appID){
            this.clientID = appID;
            return this;
        }


        @Override
        public String getIssuer(){
            return this.issuer;
        }
        @Override
        public String getClientID(){
            return this.clientID;
        }
        public TokenVerifier build(){
            return new GoogleTokenVerifier(this);
        }

    }

}





/* Exercice





 */