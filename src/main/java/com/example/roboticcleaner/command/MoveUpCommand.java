package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.RoboticCleaner;

import java.util.List;

public class MoveUpCommand implements Command {
    @Override
    public List<Integer> move(RoboticCleaner roboticCleaner) {
        List<Integer> currentPosition = roboticCleaner.getCurrentPosition();
        int oldY = currentPosition.get(1);
        int newY = oldY + 1;
        currentPosition.set(1, newY);
        return currentPosition;
    }
}
