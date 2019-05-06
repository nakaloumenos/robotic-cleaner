package com.example.roboticcleaner.domain;

import lombok.Value;

import javax.validation.constraints.Min;

@Value
public class Position {

    @Min(0)
    private int x;

    @Min(0)
    private int y;

}
