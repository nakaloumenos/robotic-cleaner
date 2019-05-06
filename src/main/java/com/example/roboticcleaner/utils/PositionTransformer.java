package com.example.roboticcleaner.utils;

import com.example.roboticcleaner.domain.Position;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class PositionTransformer {

    public static Position toPosition(final List<Integer> positionAsList) {
        return Position.builder()
                .x(positionAsList.get(0))
                .y(positionAsList.get(1))
                .build();
    }

}
