package com.example.roboticcleaner.parser;

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
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("N");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
    }

    @Test
    public void stringSMapsToMoveDownCommand() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("S");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveDownCommand);
    }

    @Test
    public void stringWMapsToMoveLeftCommand() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("W");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveLeftCommand);
    }

    @Test
    public void stringEMapsToMoveRightCommand() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("E");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveRightCommand);
    }

    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser(null);

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("nN");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveUpCommand);
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        final NavigationInstructionsParser parser = new NavigationInstructionsParser("NSWE");

        //When
        final List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveDownCommand);
        Assert.assertTrue(commands.get(2) instanceof MoveLeftCommand);
        Assert.assertTrue(commands.get(3) instanceof MoveRightCommand);

    }

}
