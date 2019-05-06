package com.example.roboticcleaner.api;

import com.example.roboticcleaner.domain.AreaSize;
import com.example.roboticcleaner.domain.Position;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class CleaningInstructions {

    @Valid
    private AreaSize areaSize;

    @Valid
    private Position startingPosition;

    @Valid
    private Set<Position> oilPatches;

    @Pattern(regexp = "[NSEW]*")
    private String navigationInstructions;
}
