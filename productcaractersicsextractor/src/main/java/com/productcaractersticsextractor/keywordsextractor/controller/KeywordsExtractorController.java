package com.productcaractersticsextractor.keywordsextractor.controller;


import com.productcaractersticsextractor.keywordsextractor.models.Keywords;
import com.productcaractersticsextractor.keywordsextractor.models.ProductCaracteristiques;
import com.productcaractersticsextractor.keywordsextractor.services.KeywordsExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KeywordsExtractorController {

    @Autowired
    KeywordsExtractorService kes;
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/keywords")
    @ResponseBody
    ResponseEntity<Keywords> extractKeywordsFromDescription(@RequestBody ProductCaracteristiques productCaracteristiques) {
        return new ResponseEntity<Keywords>(kes.extractKeywords(productCaracteristiques.getDescription()), HttpStatus.OK);
    }


}
