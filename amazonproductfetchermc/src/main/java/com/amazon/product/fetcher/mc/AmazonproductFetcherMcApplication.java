package com.amazon.product.fetcher.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmazonproductFetcherMcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonproductFetcherMcApplication.class, args);
    }

}
