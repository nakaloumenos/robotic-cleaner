package com.example.roboticcleaner.api;

import com.example.roboticcleaner.api.validation.ValidOilPatchesList;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class CleanUpRequest {

    @Size(min = 2, max = 2, message = "areaSize is not valid input")
    private final List<Integer> areaSize;

    @Size(min = 2, max = 2, message = "startingPosition is not valid input")
    private final List<Integer> startingPosition;

    @ValidOilPatchesList
    private final List<List<Integer>> oilPatches;

    @Pattern(regexp = "[NSEW]*", message = "navigationInstructions is not valid input")
    private final String navigationInstructions;

    public CleanUpRequest(final List<Integer> areaSize, final List<Integer> startingPosition,
                          final List<List<Integer>> oilPatches, final String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
    }

}
