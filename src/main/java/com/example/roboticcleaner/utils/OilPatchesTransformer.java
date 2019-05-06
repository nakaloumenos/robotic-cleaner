package com.example.roboticcleaner.utils;

import com.example.roboticcleaner.domain.Position;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@UtilityClass
public class OilPatchesTransformer {

    public static Set<Position> toSetOfOilPatches(final List<List<Integer>> oilPatchesAsLists) {
        return oilPatchesAsLists.stream()
                .map(PositionTransformer::toPosition)
                .collect(toSet());
    }

}
