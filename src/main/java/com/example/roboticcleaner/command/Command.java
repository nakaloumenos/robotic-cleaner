package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;

public interface Command {
    Position move(RoboticCleaner roboticCleaner);
}
