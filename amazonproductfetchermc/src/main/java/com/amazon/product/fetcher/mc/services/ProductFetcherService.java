package com.amazon.product.fetcher.mc.services;

import com.amazon.product.fetcher.mc.models.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class ProductFetcherService {

    WebClient.Builder webClient;
    private String baseUrl = "http://amazonscrapper-service";

    public ProductFetcherService(@Qualifier("mybean") WebClient.Builder webClient){
        this.webClient = webClient;

    }

    //Making a call to the amazonscrapper
    private ObjectMapper mapper = new ObjectMapper();

    public ProductModel[] fetchData(String keywords, int page) throws ExecutionException, InterruptedException {
        WebClient client = webClient.baseUrl(baseUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        ProductModel[] results = client.post().uri("amazonscrapper")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{ \"page\": \"" + page + "\", \"keywords\": " + keywords + " }"))
                .retrieve()
                .bodyToMono(ProductModel[].class).block();
        return results;
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