package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GAHome {

    private HashMap<String, Object> params;
}
