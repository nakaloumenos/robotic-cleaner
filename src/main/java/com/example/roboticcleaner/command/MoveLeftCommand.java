package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;

public class MoveLeftCommand implements Command {
    @Override
    public Position move(RoboticCleaner roboticCleaner) {
        Position currentPosition = roboticCleaner.getCurrentPosition();
        int oldX = currentPosition.getX();
        int newX = oldX - 1;
        currentPosition.setX(newX);
        return currentPosition;
    }
}
