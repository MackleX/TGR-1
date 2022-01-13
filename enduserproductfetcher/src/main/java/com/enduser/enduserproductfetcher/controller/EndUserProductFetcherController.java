package com.enduser.enduserproductfetcher.controller;

import com.enduser.enduserproductfetcher.helpers.CustomSecurityManager;
import com.enduser.enduserproductfetcher.model.RequestModel;
import com.enduser.enduserproductfetcher.services.EndUserProductCaractersticsExtractorService;
import com.enduser.enduserproductfetcher.services.EndUserProductFetcherService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EndUserProductFetcherController {


    //getDescription


    @Autowired
    EndUserProductFetcherService eupfs;

    @Autowired
    EndUserProductCaractersticsExtractorService epces;


    @Autowired
    CustomSecurityManager securtyManager;




    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/products/{page}")
    @ResponseBody
    ResponseEntity<?> getProductsByPage(@RequestBody RequestModel requestModel,@PathVariable int page,@RequestParam boolean byKeywords, @RequestHeader("access-token") String token) {
    if(securtyManager.verify(token)) {
        if (!byKeywords) {
            return new ResponseEntity<>(eupfs.getProducts(epces.getKeywords(requestModel.getDescription()), requestModel.getProviders(), 1), HttpStatus.OK);
        } else if (byKeywords) {
            return new ResponseEntity<>(eupfs.getProducts(requestModel.fromatKeywords(), requestModel.getProviders(), page), HttpStatus.OK);
        }

        }else
         {
        return new ResponseEntity<>("EROOR", HttpStatus.BAD_REQUEST);
    }
        return new ResponseEntity<>("WTF", HttpStatus.BAD_REQUEST);
    }



    }

