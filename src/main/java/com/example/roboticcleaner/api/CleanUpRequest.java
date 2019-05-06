package com.example.roboticcleaner.api;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class CleanUpRequest {

    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> areaSize;

    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> startingPosition;

    private final List<List<Integer>> oilPatches;

    @Pattern(regexp = "[NSEW]*")
    private final String navigationInstructions;

    public CleanUpRequest(final List<Integer> areaSize, final List<Integer> startingPosition,
                          final List<List<Integer>> oilPatches, final String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
    }

}
