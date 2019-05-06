package com.example.roboticcleaner.service;

import com.example.roboticcleaner.api.CleanUpInstructions;
import com.example.roboticcleaner.api.CleanUpResult;

public interface CleanUpService {
    CleanUpResult run(CleanUpInstructions cleanUpInstructions);
}
