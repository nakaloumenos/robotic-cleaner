package com.example.roboticcleaner.api;

import com.example.roboticcleaner.service.CleanUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class CleanUpController {

    private final CleanUpService cleanUpService;

    @PutMapping("/cleanup")
    public CleanUpResult sendCleanUpInstructions(@Valid @RequestBody CleanUpRequest cleanUpRequest) {
        log.info("Starting Clean Up Request");
        return cleanUpService.run(cleanUpRequest);
    }

}
