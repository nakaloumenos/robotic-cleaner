package com.example.roboticcleaner.api;

import com.example.roboticcleaner.service.CleaningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoboticCleanerController {

    private final CleaningService cleaningService;

    @PutMapping("/clean")
    public CleaningResult clean(@Valid @RequestBody CleaningInstructions cleaningInstructions) {
        log.info("Starting cleaning request");
        return cleaningService.clean(cleaningInstructions);
    }
}

