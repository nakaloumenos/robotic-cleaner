package com.example.roboticcleaner.domain;

import com.example.roboticcleaner.command.Command;
import com.example.roboticcleaner.exception.OutOfBoundsException;
import com.example.roboticcleaner.parser.NavigationInstructionsParser;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RoboticCleaner {

    private Position currentPosition;
    private int oilPatchesCleanedCount;

    public RoboticCleaner(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void clean(String navigationInstructions, SeaArea seaArea) {
        List<Command> commands = new NavigationInstructionsParser(navigationInstructions).toCommands();
        for (Command command : commands) {
            log.info("Cleaner is moving...");
            String commandType = command.getClass().getSimpleName();
            log.debug("Invoking " + commandType + " to cleaner");
            this.currentPosition = command.move(this);
            checkBoundariesAndDirtiness(this.currentPosition, seaArea);
        }
    }

    private void checkBoundariesAndDirtiness(Position position, SeaArea seaArea) {
        int x = position.getX();
        int y = position.getY();
        log.info("Checking if current position is within bounds");
        if (seaArea.contains(position)) {
            log.info("Position [" + x + ", " + y + "] is within bounds");
            log.info("Checking if current position has an oil spil");
            if (seaArea.hasOilPatchIn(position)) {
                log.info("Position [" + x + ", " + y + "] has oil spil");
                this.oilPatchesCleanedCount++;
                seaArea.removeDirt(position);
            }
            log.info("Position [" + x + ", " + y + "] is clean");
        } else {
            log.error("Position [" + x + ", " + y + "] is out of bounds!");
            throw new OutOfBoundsException("Position [" + x + ", " + y + "] is out of bounds!");
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getOilPatchesCleanedCount() {
        return oilPatchesCleanedCount;
    }
}
