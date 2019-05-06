package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoveUpCommandTest {

    @Test
    public void testMoveUpCommandMovesCleanerUp() {
        //Given
        final MoveUpCommand command = new MoveUpCommand();
        final Position startingPosition = Position.builder()
                .x(1)
                .y(4)
                .build();
        final RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        final Position newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(5, newPosition.getY());
    }

}
