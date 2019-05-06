package com.example.roboticcleaner.domain;

import lombok.Value;

import java.util.Set;

@Value
public class SeaArea {

    private AreaSize areaSize;
    private Set<Position> oilPatches;

    public boolean contains(Position position) {
        return position.getX() >= 0 &&
                position.getX() <= areaSize.getWidth() &&
                position.getY() >= 0 &&
                position.getY() <= areaSize.getHeight();
    }

    public boolean hasOilPatchIn(Position position) {
        return this.oilPatches.contains(position);
    }

    public void removeDirt(Position position) {
        this.oilPatches.remove(position);
    }

}
