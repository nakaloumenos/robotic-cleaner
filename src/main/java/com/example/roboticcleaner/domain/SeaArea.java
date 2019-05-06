package com.example.roboticcleaner.domain;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Value
public class SeaArea {

    private AreaSize areaSize;
    private Set<Position> oilPatches;

    public boolean hasPosition(final Position position) {
        return position.getX() <= areaSize.getWidth()
                && position.getY() <= areaSize.getHeight();
    }

    public boolean hasOilPatchIn(final Position position) {
        return this.oilPatches.contains(position);
    }

    public void removeDirt(final Position position) {
        log.info("Cleaning oil patch in position [{}, {}]", position.getX(), position.getY());
        this.oilPatches.remove(position);
    }

}
