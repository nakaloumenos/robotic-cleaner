package com.example.roboticcleaner.service.impl;

import com.example.roboticcleaner.api.CleanUpInstructions;
import com.example.roboticcleaner.api.CleanUpResult;
import com.example.roboticcleaner.domain.RoboticCleaner;
import com.example.roboticcleaner.domain.SeaArea;
import com.example.roboticcleaner.service.CleanUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CleanUpServiceImpl implements CleanUpService {

    @Override
    public CleanUpResult run(CleanUpInstructions cleanUpInstructions) {
        RoboticCleaner roboticCleaner = cleanUpInstructions.getRoboticCleaner();
        SeaArea seaArea = cleanUpInstructions.getSeaArea();
        String navigationInstructions = cleanUpInstructions.getNavigationInstructions();


        log.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        List<Integer> cleanerPosition = roboticCleaner.getCurrentPosition();
        int oilPatchesCleanedCount = roboticCleaner.getOilPatchesCleanedCount();
        return new CleanUpResult(cleanerPosition, oilPatchesCleanedCount);
    }
}
