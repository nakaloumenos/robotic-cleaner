package com.example.roboticcleaner.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class SeaAreaTest {

    private SeaArea seaArea;

    @Before
    public void setUp() {
        final AreaSize topRight = AreaSize.builder()
                .width(5)
                .height(5)
                .build();
        final Position oilPatch = Position.builder()
                .x(2)
                .y(3)
                .build();
        final Set<Position> oilPatches = new HashSet<>();
        oilPatches.add(oilPatch);
        seaArea = new SeaArea(topRight, oilPatches);
    }


    @Test
    public void positionWithCoordinateWithinBoundsIsIdentified() {
        //Given
        final Position position = Position.builder()
                .x(5)
                .y(0)
                .build();

        //Then
        Assert.assertTrue(seaArea.contains(position));
    }

    @Test
    public void positionWithPositiveXCoordinateOutsideBoundsIsIdentified() {
        //Given
        final Position position = Position.builder()
                .x(6)
                .y(0)
                .build();

        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithNegativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        final Position position = Position.builder()
                .x(-1)
                .y(0)
                .build();


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithPositiveYCoordinateOutsideBoundsIsIdentified() {

        //Given
        final Position position = Position.builder()
                .x(0)
                .y(6)
                .build();


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithNegativeYCoordinateOutsideBoundsIsIdentified() {

        //Given
        final Position position = Position.builder()
                .x(0)
                .y(-1)
                .build();


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithoutOilSpilIsIdentified() {

        //Given
        final Position position = Position.builder()
                .x(1)
                .y(0)
                .build();


        //Then
        Assert.assertFalse(seaArea.hasOilPatchIn(position));
    }

    @Test
    public void positionWithOilPatchIsIdentified() {

        //Given
        final Position position = Position.builder()
                .x(2)
                .y(3)
                .build();


        //Then
        Assert.assertTrue(seaArea.hasOilPatchIn(position));
    }

}
