package com.mydeveloperplanet.myvalidationplanet;

import java.util.HashMap;
import java.util.Set;

import com.mydeveloperplanet.myvalidationplanet.domain.Customer;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import org.springframework.stereotype.Service;

@Service
class CustomerService {

    private final HashMap<Long, Customer> customers = new HashMap<>();
    private Long index = 0L;
    private final Validator validator;

    CustomerService(Validator validator) {
        this.validator = validator;
    }

    Customer createCustomer(Customer customer) {
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Customer> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
        customer.setCustomerId(index);
        customers.put(index, customer);
        index++;
        return customer;
    }

    Customer getCustomer(Long customerId) {
        if (customers.containsKey(customerId)) {
            return customers.get(customerId);
        } else {
            return null;
        }
    }
}
