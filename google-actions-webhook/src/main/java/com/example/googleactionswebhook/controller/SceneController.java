package com.example.googleactionswebhook.controller;

import com.example.googleactionswebhook.google.api.generic.*;
import com.example.googleactionswebhook.google.api.request.GARequest;
import com.example.googleactionswebhook.google.api.response.GAResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/scene")
@Slf4j
@RestController
public class SceneController {

    @RequestMapping(path="/", method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GAResponse nextScene(@RequestBody GARequest request){
        log.info("Next scene BEGIN");
        log.info("Request: " + request);

        GAResponse response = new GAResponse(
                new GAPrompt(false,
                        new GAFirstSimple("This text comes from the server! You slay the dragon. Hi everyboy!",null),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null),
                new GAScene(null,null,null, new GANextScene("YOU_WIN")),
                request.getSession(), request.getUser(), request.getHome(),
                request.getDevice(), new GAExpected(null, null));

        log.info("Next scene END Response: "+ response);
        System.out.println(response);
        return response;
    }
}

