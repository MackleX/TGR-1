package com.enduser.enduserproductfetcher.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestModel {
    String[] providers;
    String description;
    String[] keywords;
    int page;
    public String fromatKeywords(){
        String str = "{\"keywords\":[";
        for (String s:keywords){
            str += "\"" + s + "\",";
        }
        str += "\"\"]}";
        return str;
    }
}
