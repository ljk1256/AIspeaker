package com.example.googleactionswebhook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAImage {
    /**
     * The source url of the image. Images can be JPG, PNG and GIF (animated and non-animated). For example,https://www.agentx.com/logo.png. Required.
     */
    private String url;
    /**
     * A text description of the image to be used for accessibility, e.g. screen readers. Required.
     */
    private String alt;
    /**
     * The height of the image in pixels. Optional.
     */
    private String height;
    /**
     * The width of the image in pixels. Optional.
     */
    private String width;
}
