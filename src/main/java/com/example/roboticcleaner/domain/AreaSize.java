package com.example.roboticcleaner.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AreaSize {
    private int width;
    private int height;
}
