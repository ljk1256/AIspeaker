package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GATableRow {
    /**
     * Cells in this row. The first 3 cells are guaranteed to
     * be shown but others might be cut on certain surfaces.
     * Please test with the simulator to see which cells will be shown for a given surface.
     */
    private List<GATableCell> cells;
    /**
     * Indicates whether there should be a divider after each row.
     */
    private Boolean divider;
}
