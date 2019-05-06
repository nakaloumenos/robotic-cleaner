package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoveRightCommandTest {

    @Test
    public void testMoveRightCommandMovesCleanerRight() {
        //Given
        final MoveRightCommand command = new MoveRightCommand();
        final Position startingPosition = Position.builder()
                .x(2)
                .y(4)
                .build();
        final RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        final Position newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(3, newPosition.getX());
        Assert.assertEquals(4, newPosition.getY());
    }

}
