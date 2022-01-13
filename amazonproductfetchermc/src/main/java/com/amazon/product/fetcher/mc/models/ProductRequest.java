package com.amazon.product.fetcher.mc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductRequest {
    @JsonProperty("extractedKeywords")
    String[] keywords;
    int page;

    public String getFormatedKeywords() {
        String keywordRequest = "[";
        for (int i = 0; i < keywords.length; i++) {
            if (i != keywords.length - 1) {
                keywordRequest += "\"" + keywords[i] + "\",";
            } else {
                keywordRequest += "\"" + keywords[i] + "\"]";
            }
        }
        return keywordRequest;

    }

}
