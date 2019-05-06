package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoveDownCommandTest {

    @Test
    public void testMoveDownCommandMovesCleanerDown() {
        //Given
        final MoveDownCommand command = new MoveDownCommand();
        final Position startingPosition = Position.builder()
                .x(1)
                .y(4)
                .build();
        final RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        final Position newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(1, newPosition.getX());
        Assert.assertEquals(3, newPosition.getY());
    }

}
