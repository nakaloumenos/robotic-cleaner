package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;

public class MoveDownCommand implements Command {
    @Override
    public Position move(final RoboticCleaner roboticCleaner) {
        final Position currentPosition = roboticCleaner.getCurrentPosition();
        final int oldY = currentPosition.getY();
        final int newY = oldY - 1;
        currentPosition.setY(newY);
        return currentPosition;
    }
}
