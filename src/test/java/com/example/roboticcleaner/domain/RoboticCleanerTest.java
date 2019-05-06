package com.example.roboticcleaner.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Set;

@SpringBootTest
public class RoboticCleanerTest {

    private RoboticCleaner roboticCleaner;
    private SeaArea seaArea;

    @Before
    public void setUp() {
        final Position startingPosition = Position.builder()
                .x(1)
                .y(2)
                .build();
        roboticCleaner = new RoboticCleaner(startingPosition);
    }

    @Test
    public void canProvideCurrentLocationAsString() {

        //Then
        final Position expectedPosition = Position.builder()
                .x(1)
                .y(2)
                .build();
        Assert.assertEquals(expectedPosition, roboticCleaner.getCurrentPosition());
    }

    @Test
    public void canClean() {
        //Given
        final String navigationInstructions = "NNESEESWNWW";
        final AreaSize topRight = AreaSize.builder()
                .width(5)
                .height(5)
                .build();
        final Set<Position> oilPatches = Collections.emptySet();
        final SeaArea seaArea = new SeaArea(topRight, oilPatches);

        //When
        roboticCleaner.clean(navigationInstructions, seaArea);

        //Then
        final Position expectedPosition = Position.builder()
                .x(1)
                .y(3)
                .build();
        Assert.assertEquals(expectedPosition, roboticCleaner.getCurrentPosition());
    }

}
