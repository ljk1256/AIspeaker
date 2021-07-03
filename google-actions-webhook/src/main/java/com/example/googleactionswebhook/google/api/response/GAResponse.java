package com.example.googleactionswebhook.google.api.response;

import com.example.googleactionswebhook.google.api.generic.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GAResponse {
    GAPrompt prompt;
    GAScene scene;
    GASession session;
    GAUser user;
    GAHome home;
    GADevice device;
    GAExpected expected;

    public static GAResponse textAndNextScene(String text, String nextScene) {
        return
                GAResponse.builder()
                        .prompt(
                                GAPrompt.builder()
                                        .firstSimple(GAFirstSimple.builder()
                                                .speech(text).build())
                                        .build())
                        .scene(
                                GAScene.builder().next(
                                        GANextScene.builder()
                                                .name(nextScene).build()
                                ).build())
                        .build();
    }
}