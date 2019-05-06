package com.example.roboticcleaner.parser;

import com.example.roboticcleaner.command.Command;
import com.example.roboticcleaner.domain.NavigationInstruction;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class NavigationInstructionsParser {

    private final String navigationInstructions;

    public List<Command> toCommands() {
        if (isNullOrEmpty(navigationInstructions)) return new ArrayList<>();
        return buildCommandsList(navigationInstructions);
    }

    private boolean isNullOrEmpty(final String navigationInstructions) {
        return (navigationInstructions == null || navigationInstructions.length() == 0);
    }

    private List<Command> buildCommandsList(final String navigationInstructions) {
        final List<Command> commands = new ArrayList<>();

        for (String commandCharacter : commandCharactersFrom(navigationInstructions)) {
            if (commandCharacter == null) break;
            final Command mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(""), 0, commandString.length() + 1);
    }

    private Command lookupEquivalentCommand(final String commandString) {
        return NavigationInstruction.valueOf(commandString).getCommand();
    }

}
