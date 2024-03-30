package com.mydeveloperplanet.myvalidationplanet.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DutchZipcodeValidator implements ConstraintValidator<DutchZipcode, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("\\b\\d{4}\\s?[a-zA-Z]{2}\\b");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
