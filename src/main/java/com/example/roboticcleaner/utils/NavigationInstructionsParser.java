package com.example.roboticcleaner.utils;

import com.example.roboticcleaner.command.Command;
import com.example.roboticcleaner.domain.NavigationInstruction;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@UtilityClass
public class NavigationInstructionsParser {

    public static List<Command> toCommands(final String navigationInstructions) {
        if (Strings.isBlank(navigationInstructions)) {
            return emptyList();
        }
        return buildCommandsList(navigationInstructions);
    }

    private List<Command> buildCommandsList(final String navigationInstructions) {
        return stream(navigationInstructions.split(""))
                .map(NavigationInstructionsParser::lookupEquivalentCommand)
                .collect(toList());
    }

    private Command lookupEquivalentCommand(final String commandString) {
        return NavigationInstruction.valueOf(commandString).getCommand();
    }

}
