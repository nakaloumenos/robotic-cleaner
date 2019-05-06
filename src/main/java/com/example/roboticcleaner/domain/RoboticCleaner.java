package com.example.roboticcleaner.domain;

import com.example.roboticcleaner.command.Command;
import com.example.roboticcleaner.exception.OutOfBoundsException;
import com.example.roboticcleaner.parser.NavigationInstructionsParser;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RoboticCleaner {

    private List<Integer> currentPosition;
    private int oilPatchesCleanedCount;

    public RoboticCleaner(List<Integer> currentPosition) {
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

    private void checkBoundariesAndDirtiness(List<Integer> position, SeaArea seaArea) {
        int x = position.get(0);
        int y = position.get(1);
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

    public List<Integer> getCurrentPosition() {
        return currentPosition;
    }

    public int getOilPatchesCleanedCount() {
        return oilPatchesCleanedCount;
    }
}
