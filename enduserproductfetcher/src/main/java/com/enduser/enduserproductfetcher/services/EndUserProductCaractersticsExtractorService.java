package com.enduser.enduserproductfetcher.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EndUserProductCaractersticsExtractorService {

    private String baseUrl = "http://amazon-product-fetcher-service";


    WebClient.Builder webClient;
    EndUserProductCaractersticsExtractorService(@Qualifier("mybean") WebClient.Builder webClient){
        this.webClient = webClient;
    }

    public String getKeywords(String description) {
            WebClient client = webClient.baseUrl("http://product-caracteristics-analyser").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
            String result = client.post()
                    .uri("keywords")
                    .accept(MediaType.APPLICATION_JSON)
                    .body(Mono.just("{ \"description\":" + "\"" + description + "\"}" ), String.class)
                    .retrieve()
                    .bodyToMono(String.class).block();
            return result;

    }








}
