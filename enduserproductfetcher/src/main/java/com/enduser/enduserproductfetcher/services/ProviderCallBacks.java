package com.enduser.enduserproductfetcher.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;



@Service
public class ProviderCallBacks {
    Map<String, ProviderCallBack> providers;
    private String baseUrl = "http://amazon-product-fetcher-service";


    WebClient.Builder webClient;



    public ProviderCallBacks(@Qualifier("mybean") WebClient.Builder webClient){
        providers = new HashMap<String, ProviderCallBack>();
        providers.put("Amazon", new amazonProvider());
        this.webClient = webClient;
    }



    class amazonProvider implements ProviderCallBack{
        @Override
        public String callProvider(String keywords,int page) {
            WebClient client = webClient.baseUrl(baseUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
            String result = client.post()
                        .uri(builder -> builder.path("Products").queryParam("page", page).build())
                        .accept(MediaType.APPLICATION_JSON)
                        .body(Mono.just(keywords),String.class)
                        .retrieve()
                        .bodyToMono(String.class).  block();
                return result;

        }
    }


}


@AllArgsConstructor
@NoArgsConstructor
@Data
class ProductRequest {
    String[] keywords;
    int page;

}


interface ProviderCallBack{

    String callProvider(String strings,int page);
}

