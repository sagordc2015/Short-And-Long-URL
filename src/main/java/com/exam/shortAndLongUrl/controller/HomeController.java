package com.exam.shortAndLongUrl.controller;

import com.exam.shortAndLongUrl.service.ShortAndLongUrlDataService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
public class HomeController {

    private Map<String, Object> mapObj = new HashMap<>();
    private ShortAndLongUrlDataService shortAndLongUrlDataService;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("message",   "Welcome to Simple Solution home page!");
//        return "index";
//    }

    @GetMapping("/")
    public ModelAndView index(Model model) {
        return new ModelAndView("/WEB-INF/views/home.jsp");
    }

    @PostMapping("/longToShortUrl")
    public Map<String , Object> LongToShortUrl(@RequestParam String longUrl) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(longUrl);
        if(mapObj.containsKey(longUrl)){
            map.put("msg", longUrl + " is Already Stored!!!");
            map.put("code", "1");
            map.put("url", mapObj.get(longUrl));
        }else{
            shortAndLongUrlDataService = new ShortAndLongUrlDataService(longUrl, 9);
            String shortUrl = shortAndLongUrlDataService.generateShortUrl(longUrl);
            if("".equals(shortUrl)){
                map.put("msg", longUrl + " is not a valid URL!!!");
                map.put("code", "2");
            }else{
                mapObj.put(longUrl, shortUrl);
                map.put("msg", longUrl + " valid URL!!!");
                map.put("code", "0");
                map.put("url", shortUrl);
            }
        }
        printMap();
        return map;
    }

    @PostMapping("/shortToLongUrl/{shortUrl}")
    public Map<String , Object> shortToLongUrl(@PathVariable String shortUrl) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(shortUrl);
        if(mapObj.containsValue(shortUrl)){
            map.put("msg", shortUrl + " valid URL!!!");
            map.put("code", "0");
            String url = "";
            for(Map.Entry<String, Object> entry: mapObj.entrySet()) {
                if(entry.getValue().equals(shortUrl)) {
                    url = entry.getKey();
                    break;
                }
            }
            map.put("url", url);
        }else {
            map.put("code", "1");
            map.put("msg", shortUrl + " is not a Short URL, Please Long URL Add First!!!");
        }
        return map;
    }

    private void printMap(){
        mapObj.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
