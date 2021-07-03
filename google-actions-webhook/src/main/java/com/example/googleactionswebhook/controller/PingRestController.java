package com.example.googleactionswebhook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class PingRestController {

    @GetMapping("/")
    public String welcome(){
        return "Welcome!!... " + LocalDateTime.now();
    }
}