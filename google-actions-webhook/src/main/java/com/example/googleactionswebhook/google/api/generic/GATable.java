package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GATable {
    private String title;
    private String subtitle;
    private GAImage image;
    private List<GATableColumn> columns;
    private List<GATableRow> rows;
    private GALink button;
}
