package com.exam.shortAndLongUrl.utility;

import java.util.Random;

public class UrlValidation {

    private Random random;

    public boolean urlValidate(String urlName){
        return urlName.matches("\\b(https://?|ftp://|file://|www.)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }

    public String differentProtocal(String urlName) {
        if (urlName.substring(0, 7).equals("http://")){
            urlName = urlName.substring(7);
        }
        if (urlName.substring(0, 8).equals("https://")){
            urlName = urlName.substring(8);
        }
        if (urlName.charAt(urlName.length() - 1) == '/'){
            urlName = urlName.substring(0, urlName.length() - 1);
        }
        return urlName;
    }

    public String randomKeyGenerate(int len, char[] chars){
        random = new Random();
        StringBuilder randomKey = new StringBuilder();
        for(int i = 0; i <= len; i++){
            randomKey.append(chars[random.nextInt(62)]);
        }
        return randomKey.toString();
    }

//    public String randomKeyGenerate(int len, char[] chars){
//        random = new Random();
//        String randomKey = "";
//        for(int i = 0; i <= len; i++){
//            randomKey += chars[random.nextInt(62)];
//        }
//        return randomKey;
//    }

}
