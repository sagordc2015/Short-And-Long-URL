package com.exam.shortAndLongUrl.service;

import com.exam.shortAndLongUrl.utility.UrlValidation;

import java.util.HashMap;
import java.util.Map;

public class ShortAndLongUrlDataService {

    private Map<String, String> keyValueData;
    private String urlName;
    private int len;
    private char[] chars;

    private UrlValidation urlValidation;

    private ShortAndLongUrlDataService(){
        urlValidation = new UrlValidation();
        keyValueData = new HashMap<>();
        chars = new char[62];
        len = 8;
        for(int i = 0; i < 62; i++){
            int k;
            if(i < 10){
                k = i + 48;
            }else if(i <= 35){
                k = i + 55;
            }else{
                k = i + 61;
            }
            chars[i] = (char) k;
        }
        urlName = "http://www.test.com";
    }

    public ShortAndLongUrlDataService(String newUrlName, int len){
        this();
        this.len = len;
        if(!newUrlName.isEmpty()){
            newUrlName = urlValidation.differentProtocal(newUrlName);
            urlName = newUrlName;
        }
    }

    public String generateShortUrl(String longUrl){
        String shortUrl = "";
        if(urlValidation.urlValidate(longUrl)){
            longUrl = urlValidation.differentProtocal(longUrl);
            if(keyValueData.containsKey(longUrl)){
                shortUrl = keyValueData.get(longUrl);
            }else {
                shortUrl = getRandomKey(longUrl);
            }
        }
        return shortUrl;
    }

    private String getRandomKey(String longUrl){
        String randomKey = urlValidation.randomKeyGenerate(len, chars);
        keyValueData.put(longUrl, randomKey);
        return randomKey;
    }

}
