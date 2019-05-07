package com.example.roboticcleaner.domain;

import com.example.roboticcleaner.command.Command;
import com.example.roboticcleaner.exception.OutOfBoundsException;
import com.example.roboticcleaner.utils.NavigationInstructionsParser;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RoboticCleaner {

    private Position currentPosition;
    private int oilPatchesCleanedCount;

    public RoboticCleaner(final Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void clean(final String navigationInstructions, final SeaArea seaArea) {
        checkRoboticCleanerStartsWithinBounds(this.currentPosition, seaArea);
        List<Command> commands = NavigationInstructionsParser.toCommands(navigationInstructions);
        for (Command command : commands) {
            log.info("Cleaner is moving...");
            String commandType = command.getClass().getSimpleName();
            log.debug("Invoking " + commandType + " to cleaner");
            this.currentPosition = command.move(this);
            checkBoundariesAndDirtiness(this.currentPosition, seaArea);
        }
    }

    private void checkRoboticCleanerStartsWithinBounds(final Position startingPosition, final SeaArea seaArea) {
        log.info("Checking if robotic cleaner is within bounds");
        if (!seaArea.contains(this.currentPosition)) {
            log.debug("Position [" + startingPosition.getX() + ", " + startingPosition.getY() + "] is out of bounds!");
            throw new OutOfBoundsException("Robotic cleaner started out of bounds!");
        }
    }

    private void checkBoundariesAndDirtiness(final Position position, final SeaArea seaArea) {
        checkRoboticCleanerNavigatedBounds(position, seaArea);
        checkForOilSpillAndClean(position, seaArea);
    }

    private void checkRoboticCleanerNavigatedBounds(final Position position, final SeaArea seaArea) {
        log.info("Checking if current position is within bounds");
        if (!seaArea.contains(position)) {
            log.debug("Position [" + position.getX() + ", " + position.getY() + "] is out of bounds!");
            throw new OutOfBoundsException("Robotic cleaner navigated out of bounds!");
        }
        log.info("Position [" + position.getX() + ", " + position.getY() + "] is within bounds");
    }

    private void checkForOilSpillAndClean(final Position position, final SeaArea seaArea) {
        if (seaArea.hasOilPatchIn(position)) {
            log.info("Position [" + position.getX() + ", " + position.getY() + "] has oil spill");
            this.oilPatchesCleanedCount++;
            seaArea.removeDirt(position);
            log.info("Position [" + position.getX() + ", " + position.getY() + "] is clean");
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getOilPatchesCleanedCount() {
        return oilPatchesCleanedCount;
    }
}
