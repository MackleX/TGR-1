package com.token.issuer.service.service.tokenverifier.google;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.client.http.javanet.NetHttpTransport;


import com.google.api.client.json.gson.GsonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class GoogleClientDependencies {
        public static JsonFactory GsonFactory() {
            return GsonFactory.getDefaultInstance();
        }
        public static HttpTransport httpTransport() {
            return new NetHttpTransport();
        }
}
