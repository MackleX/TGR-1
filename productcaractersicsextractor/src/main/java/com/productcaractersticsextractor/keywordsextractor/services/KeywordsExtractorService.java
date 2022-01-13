package com.productcaractersticsextractor.keywordsextractor.services;

import com.productcaractersticsextractor.keywordsextractor.models.Keywords;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KeywordsExtractorService {

    WebClient.Builder webClient;
    private String baseUrl = "http://amazonscrapper-service";

    public KeywordsExtractorService(@Qualifier("mybean") WebClient.Builder webClient){
        this.webClient = webClient;

    }

    public Keywords extractKeywords(String DescriptionText) {
        WebClient client = webClient.baseUrl(baseUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Keywords keywords = client.post()
                .uri("/nlptext")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{ \"text\": \"" + DescriptionText + "\" }"))
                .retrieve()
                .bodyToMono(Keywords.class).block();

        return keywords;
    }


}


@Configuration
class config{
    @Bean
    @Qualifier("mybean")
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }
}
