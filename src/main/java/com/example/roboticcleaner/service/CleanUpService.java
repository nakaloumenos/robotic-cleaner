package com.example.roboticcleaner.service;

import com.example.roboticcleaner.api.CleanUpRequest;
import com.example.roboticcleaner.api.CleanUpResult;

public interface CleanUpService {
    CleanUpResult run(final CleanUpRequest cleanUpRequest);
}
