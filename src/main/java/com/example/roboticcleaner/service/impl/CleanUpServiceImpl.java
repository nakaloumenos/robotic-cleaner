package com.example.roboticcleaner.service.impl;

import com.example.roboticcleaner.api.CleanUpRequest;
import com.example.roboticcleaner.api.CleanUpResult;
import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import com.example.roboticcleaner.domain.SeaArea;
import com.example.roboticcleaner.service.CleanUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CleanUpServiceImpl implements CleanUpService {

    @Override
    public CleanUpResult run(CleanUpRequest cleanUpRequest) {
        RoboticCleaner roboticCleaner = cleanUpRequest.getRoboticCleaner();
        SeaArea seaArea = cleanUpRequest.getSeaArea();
        String navigationInstructions = cleanUpRequest.getNavigationInstructions();


        log.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        Position cleanerPosition = roboticCleaner.getCurrentPosition();
        int oilPatchesCleanedCount = roboticCleaner.getOilPatchesCleanedCount();
        return new CleanUpResult(cleanerPosition, oilPatchesCleanedCount);
    }
}
