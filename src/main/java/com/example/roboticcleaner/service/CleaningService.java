package com.example.roboticcleaner.service;

import com.example.roboticcleaner.api.CleaningInstructions;
import com.example.roboticcleaner.api.CleaningResult;

public interface CleaningService {
    CleaningResult clean(final CleaningInstructions cleaningInstructions);
}
