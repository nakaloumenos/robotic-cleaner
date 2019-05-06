package com.example.roboticcleaner.domain;

import lombok.Value;

import javax.validation.constraints.Min;

@Value
public class AreaSize {

    @Min(0)
    private int width;

    @Min(0)
    private int height;

}
