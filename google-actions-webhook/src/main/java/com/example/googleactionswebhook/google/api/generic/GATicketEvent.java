package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GATicketEvent {
    private GAType type;
    private String name;
    private String description;
    private String url;
    private GALocation location;
    private List<GAEventCharacter> eventCharacters;
    private GATime startDate;
    private GATime endDate;
    private GATime doorTime;
}
