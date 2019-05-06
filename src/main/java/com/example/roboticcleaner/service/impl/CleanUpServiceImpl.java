package com.example.roboticcleaner.service.impl;

import com.example.roboticcleaner.api.CleanUpRequest;
import com.example.roboticcleaner.api.CleanUpResult;
import com.example.roboticcleaner.domain.Position;
import com.example.roboticcleaner.domain.RoboticCleaner;
import com.example.roboticcleaner.domain.SeaArea;
import com.example.roboticcleaner.service.CleanUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.roboticcleaner.utils.OilPatchesTransformer.toSetOfOilPatches;
import static com.example.roboticcleaner.utils.PositionTransformer.toPosition;
import static com.example.roboticcleaner.utils.SeaAreaTransformer.toAreaSize;

@Slf4j
@Service
public class CleanUpServiceImpl implements CleanUpService {

    @Override
    public CleanUpResult run(final CleanUpRequest cleanUpRequest) {
        final RoboticCleaner roboticCleaner = createRoboticCleaner(cleanUpRequest.getStartingPosition());
        final SeaArea seaArea = createSeaArea(cleanUpRequest.getAreaSize(), cleanUpRequest.getOilPatches());
        final String navigationInstructions = cleanUpRequest.getNavigationInstructions();

        log.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        final Position cleanerPosition = roboticCleaner.getCurrentPosition();
        final int oilPatchesCleanedCount = roboticCleaner.getOilPatchesCleanedCount();
        return new CleanUpResult(cleanerPosition, oilPatchesCleanedCount);
    }

    private RoboticCleaner createRoboticCleaner(final List<Integer> startingPosition) {
        return new RoboticCleaner(toPosition(startingPosition));
    }

    private SeaArea createSeaArea(final List<Integer> areaSize, List<List<Integer>> oilPatches) {
        return new SeaArea(toAreaSize(areaSize), toSetOfOilPatches(oilPatches));
    }

}
