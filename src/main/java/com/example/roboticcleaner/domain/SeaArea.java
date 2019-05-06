package com.example.roboticcleaner.domain;

import lombok.Value;

import java.util.Set;

@Value
public class SeaArea {

    private final AreaSize areaSize;
    private final Set<Position> oilPatches;

    public boolean contains(final Position position) {
        return position.getX() >= 0 &&
                position.getX() <= areaSize.getWidth() &&
                position.getY() >= 0 &&
                position.getY() <= areaSize.getHeight();
    }

    public boolean hasOilPatchIn(final Position position) {
        return this.oilPatches.contains(position);
    }

    public void removeDirt(final Position position) {
        this.oilPatches.remove(position);
    }

}
