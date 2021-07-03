package com.example.googleactionswebhook.controller;

import com.example.googleactionswebhook.google.api.request.GARequest;
import com.example.googleactionswebhook.google.api.response.GAResponse;
import com.example.googleactionswebhook.ssml.SSMLBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/scene/ssml")
@Slf4j
@RestController
public class SSMLSceneController {

    @RequestMapping(path = "/", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GAResponse nextScene(@RequestBody GARequest request) {
        log.info("Next scene BEGIN");
        log.info("Request: " + request);

        GAResponse response =
                GAResponse.textAndNextScene(SSMLBuilder.DEMOExample(),
                        "LASTSCENE");

        log.info("Next scene END Response: " + response);
        return response;
    }
}