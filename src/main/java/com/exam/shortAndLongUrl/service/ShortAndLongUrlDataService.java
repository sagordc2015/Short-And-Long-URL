package com.exam.shortAndLongUrl.service;

import com.exam.shortAndLongUrl.utility.UrlValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShortAndLongUrlDataService {
    private Map<String, String> keyData;
    private Map<String, String> valueData;
    private String urlName;
    private int len;
    private char chars[];
    private Random random;

    private UrlValidation urlValidation = new UrlValidation();

    public ShortAndLongUrlDataService(){
        keyData = new HashMap<>();
        valueData = new HashMap<>();
        random = new Random();
        chars = new char[62];
        len = 8;
        for(int i = 0; i < 62; i++){
            int k = 0;
            if(i < 10){
                k = i + 48;
            }else if(i > 9 && i <= 35){
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
}
