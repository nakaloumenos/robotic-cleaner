package com.example.roboticcleaner.command;

import com.example.roboticcleaner.domain.RoboticCleaner;

import java.util.List;

public interface Command {
    List<Integer> move(RoboticCleaner roboticCleaner);
}
