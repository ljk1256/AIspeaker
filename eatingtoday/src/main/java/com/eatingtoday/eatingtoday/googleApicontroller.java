package com.eatingtoday.eatingtoday;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class googleApicontroller {

    @PostMapping(value = "/intents/", consumes = MediaType.APPLICATION_JSON_VALUE)

    public String postMethod(){
        return "Hello world";
    }
}
