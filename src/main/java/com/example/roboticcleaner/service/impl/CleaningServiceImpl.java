package com.example.roboticcleaner.service.impl;

import com.example.roboticcleaner.api.CleaningInstructions;
import com.example.roboticcleaner.api.CleaningResult;
import com.example.roboticcleaner.domain.RoboticCleaner;
import com.example.roboticcleaner.domain.SeaArea;
import com.example.roboticcleaner.service.CleaningService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CleaningServiceImpl implements CleaningService{
    @Override
    public CleaningResult clean(CleaningInstructions cleaningInstructions) {
        final SeaArea seaArea = new SeaArea(cleaningInstructions.getAreaSize(), cleaningInstructions.getOilPatches());
        final RoboticCleaner roboticCleaner = new RoboticCleaner(cleaningInstructions.getStartingPosition(), 0);
        String navigationInstructions = cleaningInstructions.getNavigationInstructions();

        log.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        return new CleaningResult(roboticCleaner.getCurrentPosition(), roboticCleaner.getOilPatchesCleanedCount());
    }
}
