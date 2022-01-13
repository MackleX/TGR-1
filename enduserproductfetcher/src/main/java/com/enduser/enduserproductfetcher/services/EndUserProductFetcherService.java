package com.enduser.enduserproductfetcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EndUserProductFetcherService {

    @Autowired
    ProviderCallBacks pcb;
    public String getProducts(String keywords,String[] providers,int page){
        System.out.println("");
        String result = pcb.providers.get("Amazon").callProvider(keywords,page);
        return result;
    }


}
