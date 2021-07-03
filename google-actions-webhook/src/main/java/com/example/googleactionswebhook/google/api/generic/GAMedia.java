package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAMedia {

    private GAMediaType mediaType;
    private String startOffset;
    private List<GAMediaObject> optionalMediaControls;
}
