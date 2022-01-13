package com.amazon.product.fetcher.mc.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServerResponse {
    ProductModel[] products;
    String[] keywords;
}
