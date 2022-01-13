package com.enduser.enduserproductfetcher.helpers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class CustomSecurityManager {

    WebClient.Builder webClient;
    private String baseUrl = "http://tokenissuer";


    CustomSecurityManager(@Qualifier("mybean") WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public boolean verify(String toknen) {
        WebClient client = webClient.baseUrl("http://tokenissuer").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        boolean result = client.post()
                .uri(builder -> builder.path("/tokenmanager/verifygoogletoken").queryParam("access-token", toknen).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Boolean.class).block();
        return result;


    }
}
