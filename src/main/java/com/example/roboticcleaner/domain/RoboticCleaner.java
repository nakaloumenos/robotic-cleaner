package com.example.roboticcleaner.domain;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Value
public class RoboticCleaner {
    private Position currentPosition;
    private int oilPatchesCleanedCount;
}
