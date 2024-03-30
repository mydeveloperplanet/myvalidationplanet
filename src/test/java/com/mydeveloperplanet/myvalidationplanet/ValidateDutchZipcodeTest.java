package com.mydeveloperplanet.myvalidationplanet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import com.mydeveloperplanet.myvalidationplanet.domain.Address;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

class ValidateDutchZipcodeTest {

    @Test
    void whenZipcodeIsValid_thenOk() {
        Address address = new Address("street", "2845AA");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertTrue(violations.isEmpty());
    }

    @Test
    void whenZipcodeIsInvalid_thenNotOk() {
        Address address = new Address("street", "2845");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertFalse(violations.isEmpty());
    }

}
