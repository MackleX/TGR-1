package com.amazon.product.fetcher.mc.controller;

import com.amazon.product.fetcher.mc.models.ProductRequest;
import com.amazon.product.fetcher.mc.models.ServerResponse;
import com.amazon.product.fetcher.mc.services.ProductFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ProductFetcherController {


    @Autowired
    ProductFetcherService pf;
    @PostMapping("/Products")
    @ResponseBody
    ResponseEntity<ServerResponse> replaceEmployee(@RequestBody ProductRequest form, @RequestParam int page) throws ExecutionException, InterruptedException {
        return new ResponseEntity<ServerResponse>(new ServerResponse(pf.fetchData(form.getFormatedKeywords(), page),form.getKeywords()), HttpStatus.OK);
    }


}

