package com.example.roboticcleaner.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class OilPatchesList implements ConstraintValidator<ValidOilPatchesList, List<List<Integer>>> {
    @Override
    public void initialize(ValidOilPatchesList constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<List<Integer>> oilPatches, ConstraintValidatorContext context) {
        return oilPatches.stream().allMatch(oilPatch -> oilPatch.size() == 2);
    }
}
