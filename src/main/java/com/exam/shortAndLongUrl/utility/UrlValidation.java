package com.exam.shortAndLongUrl.utility;

public class UrlValidation {

    public boolean urlValidate(String url){
        boolean check = url.matches("\\b(https://?|ftp://|file://|www.)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        return check;
    }

    public String differentProtocal(String url) {
        if (url.substring(0, 7).equals("http://")){
            url = url.substring(7);
        }
        if (url.substring(0, 8).equals("https://")){
            url = url.substring(8);
        }
        if (url.charAt(url.length() - 1) == '/'){
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

}
