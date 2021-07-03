package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAContent {

    private GAContentCard card;
    private GAImage image;
    private GATable table;
    private GAMedia media;
    private GACollection collection;
    private GAList list;
}
