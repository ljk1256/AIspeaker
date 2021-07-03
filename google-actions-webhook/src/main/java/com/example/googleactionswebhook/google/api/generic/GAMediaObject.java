package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAMediaObject {

    private String name;
    private String description;
    private String url;
    private GAMediaImage image;
}
