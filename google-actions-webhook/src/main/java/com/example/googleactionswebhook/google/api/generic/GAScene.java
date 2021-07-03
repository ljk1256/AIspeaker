package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GAScene {

    private String name;
    private String slotFillingStatus;
    private HashMap<String, Object> slots;
    private GANextScene next;
}
