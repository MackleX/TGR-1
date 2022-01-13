package com.token.issuer.service.service.tokenverifier;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenVerifierBeans {


    @Bean
    public TokenVerifier googleTokenVerifier() throws Exception {
        TokenVerifierBuilderFactory tokenVerifierBuilderFactory = new TokenVerifierBuilderFactory();
        return   tokenVerifierBuilderFactory
                .getTokenVerifier("GOOGLE")
                .tokenVerifierBuilder()
                .clientID("304615553988-vo00igf42uo4tkhtn070gunkpnb6bsec.apps.googleusercontent.com")
                .build();

    }
}
