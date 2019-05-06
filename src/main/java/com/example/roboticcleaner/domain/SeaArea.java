package com.example.roboticcleaner.domain;

import java.awt.*;
import java.util.List;

public class SeaArea {

    private List<Integer> topRightCorner;
    private List<List<Integer>> oilPatches;

    private Point topRightCornerP;

    public SeaArea(List<Integer> topRightCorner, List<List<Integer>> oilPatches) {
        this.topRightCorner = topRightCorner;
        this.oilPatches = oilPatches;
    }

    public boolean contains(List<Integer> position) {
        int x = position.get(0);
        int y = position.get(1);
        return x >= 0 && y >= 0 &&
                x <= topRightCorner.get(0) && y <= topRightCorner.get(1);
    }

    public boolean hasOilPatchIn(List<Integer> position) {
        return this.oilPatches.contains(position);
    }

    public void removeDirt(List<Integer> position) {
        this.oilPatches.remove(position);
    }

    public List<Integer> getTopRightCorner() {
        return topRightCorner;
    }

    public List<List<Integer>> getOilPatches() {
        return oilPatches;
    }


}
