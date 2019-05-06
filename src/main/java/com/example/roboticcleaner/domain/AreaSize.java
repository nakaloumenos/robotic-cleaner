package com.example.roboticcleaner.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AreaSize {
    private final int width;
    private final int height;
}
