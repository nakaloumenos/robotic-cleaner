package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoveLeftCommandTest {
    @Test
    public void testMoveLeftCommandMovesCleanerLeft() {
        //Given
        final MoveLeftCommand command = new MoveLeftCommand();
        final Position startingPosition = Position.builder()
                .x(2)
                .y(4)
                .build();
        final RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        final Position newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(4, newPosition.getY());
    }
}
