package com.example.roboticcleaner.api;

import com.example.roboticcleaner.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CleaningResult {
    private Position finalPosition;
    private int oilPatchesCleaned;
}
