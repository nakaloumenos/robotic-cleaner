package com.example.roboticcleaner.utils;

import com.example.roboticcleaner.command.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NavigationInstructionsParserTest {

    @Test
    public void stringNMapsToMoveUpCommand() {
        //Given
        final String navigationInstructions = "N";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
    }

    @Test
    public void stringSMapsToMoveDownCommand() {
        //Given
        final String navigationInstructions = "S";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveDownCommand);
    }

    @Test
    public void stringWMapsToMoveLeftCommand() {
        //Given
        final String navigationInstructions = "W";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveLeftCommand);
    }

    @Test
    public void stringEMapsToMoveRightCommand() {
        //Given
        final String navigationInstructions = "E";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveRightCommand);
    }

    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        final String navigationInstructions = "";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        final String navigationInstructions = null;

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        final String navigationInstructions = "NSWE";

        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveDownCommand);
        Assert.assertTrue(commands.get(2) instanceof MoveLeftCommand);
        Assert.assertTrue(commands.get(3) instanceof MoveRightCommand);

    }

}
