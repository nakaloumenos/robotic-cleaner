package com.example.roboticcleaner.utils;

import com.example.roboticcleaner.domain.AreaSize;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SeaAreaTransformer {

    public static AreaSize toAreaSize(final List<Integer> areaSizeAsList) {
        return AreaSize.builder()
                .width(areaSizeAsList.get(0))
                .height(areaSizeAsList.get(1))
                .build();
    }

}
