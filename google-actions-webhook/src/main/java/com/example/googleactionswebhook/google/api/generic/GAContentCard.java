package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAContentCard {
    private String title;
    private String subtitle;
    private String text;
    private GAImage image;
    private GAImageFill imageFill;
    private GALink button;
}
