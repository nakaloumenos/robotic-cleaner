package com.example.roboticcleaner.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = OilPatchesList.class)
public @interface ValidOilPatchesList {
    String message() default "oilPatches is not valid input";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
