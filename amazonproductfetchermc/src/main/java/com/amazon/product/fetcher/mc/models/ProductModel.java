package com.amazon.product.fetcher.mc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonRootName(value = "products")
public class ProductModel {
    String url;
    String title;
    String rating;
    String reviews;
    String price;
    String oldPrice;
    String image;
    String description;
    Boolean bestseller;
}
