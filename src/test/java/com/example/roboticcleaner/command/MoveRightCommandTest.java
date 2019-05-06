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
        MoveRightCommand command = new MoveRightCommand();
        Position startingPosition = Position.builder()
                .x(2)
                .y(4)
                .build();
        RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        Position newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(3, (int) newPosition.getX());
        Assert.assertEquals(4, (int) newPosition.getY());
    }

}
