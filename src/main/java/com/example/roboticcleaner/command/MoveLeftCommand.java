package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;

public class MoveLeftCommand implements Command {
    @Override
    public Position move(final RoboticCleaner roboticCleaner) {
        final Position currentPosition = roboticCleaner.getCurrentPosition();
        final int oldX = currentPosition.getX();
        final int newX = oldX - 1;
        currentPosition.setX(newX);
        return currentPosition;
    }
}
