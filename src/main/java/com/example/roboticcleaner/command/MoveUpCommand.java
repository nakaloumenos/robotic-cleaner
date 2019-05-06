package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;

public class MoveUpCommand implements Command {
    @Override
    public Position move(RoboticCleaner roboticCleaner) {
        Position currentPosition = roboticCleaner.getCurrentPosition();
        int oldY = currentPosition.getY();
        int newY = oldY + 1;
        currentPosition.setY(newY);
        return currentPosition;
    }
}
