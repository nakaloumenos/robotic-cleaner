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
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("N");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
    }

    @Test
    public void stringSMapsToMoveDownCommand() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("S");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveDownCommand);
    }

    @Test
    public void stringWMapsToMoveLeftCommand() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("W");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveLeftCommand);
    }

    @Test
    public void stringEMapsToMoveRightCommand() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("E");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveRightCommand);
    }

    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("");

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands(null);

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("nN");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveUpCommand);
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //When
        final List<Command> commands = NavigationInstructionsParser.toCommands("NSWE");

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveDownCommand);
        Assert.assertTrue(commands.get(2) instanceof MoveLeftCommand);
        Assert.assertTrue(commands.get(3) instanceof MoveRightCommand);

    }

}
