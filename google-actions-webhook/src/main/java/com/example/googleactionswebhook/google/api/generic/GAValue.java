package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAValue {
    /**
 *  	 	Represents a null value.
 */
    private GANullValue null_value;
    // 	Represents a double value. Note that attempting to serialize NaN or Infinity results in error. (We can't serialize these as string "NaN" or "Infinity" values like we do for regular fields, because they would parse as string_value, not number_value).
    private Double number_value;
    private String string_value;
    private Boolean bool_value;
    private GAStruct struct_value;
    private List<GAValue> list_value;
}
