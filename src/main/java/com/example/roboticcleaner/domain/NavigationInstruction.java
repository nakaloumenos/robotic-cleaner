package com.example.roboticcleaner.domain;

import com.example.roboticcleaner.command.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NavigationInstruction {
    N(new MoveUpCommand()),
    S(new MoveDownCommand()),
    W(new MoveLeftCommand()),
    E(new MoveRightCommand());

    private final Command command;

}
