package com.mydeveloperplanet.myvalidationplanet.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DutchZipcodeValidator.class)
@Documented
public @interface DutchZipcode {

    String message() default "A Dutch zipcode must contain 4 digits followed by two letters";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
