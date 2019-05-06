package com.example.roboticcleaner.api;

import com.example.roboticcleaner.domain.AreaSize;
import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import com.example.roboticcleaner.domain.SeaArea;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class CleanUpRequest {
    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> areaSize;

    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> startingPosition;

    private final List<List<Integer>> oilPatches;
    private final String navigationInstructions;

    private SeaArea seaArea;
    private RoboticCleaner roboticCleaner;

    public CleanUpRequest(List<Integer> areaSize, List<Integer> startingPosition, List<List<Integer>> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;

        this.seaArea = new SeaArea(toAreaSize(areaSize), toSetOfOilPatches(oilPatches));
        this.roboticCleaner = new RoboticCleaner(toPosition(startingPosition));
    }

    private AreaSize toAreaSize(List<Integer> areaSizeAsList) {
        return AreaSize.builder()
                .width(areaSizeAsList.get(0))
                .height(areaSizeAsList.get(1))
                .build();
    }

    private Set<Position> toSetOfOilPatches(List<List<Integer>> oilPatchesAsLists) {
        final Set<Position> oilPatches = new HashSet<>();
        oilPatchesAsLists.forEach(oilPatchAsList -> {
            oilPatches.add(toPosition(oilPatchAsList));
        });
        return oilPatches;
    }

    private Position toPosition(List<Integer> positionAsList) {
        return Position.builder()
                .x(positionAsList.get(0))
                .y(positionAsList.get(1))
                .build();
    }

}
