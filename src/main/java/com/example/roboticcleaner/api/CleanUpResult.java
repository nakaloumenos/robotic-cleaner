package com.example.roboticcleaner.api;

import com.example.roboticcleaner.domain.Position;
import lombok.Value;

@Value
public class CleanUpResult {
    private final Position finalPosition;
    private final int oilPatchesCleaned;
}
