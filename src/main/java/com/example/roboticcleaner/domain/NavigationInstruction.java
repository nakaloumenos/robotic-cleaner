package com.example.roboticcleaner.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NavigationInstruction {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String direction;

}
