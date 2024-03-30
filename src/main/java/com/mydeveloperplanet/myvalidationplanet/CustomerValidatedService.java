package com.mydeveloperplanet.myvalidationplanet;

import java.util.HashMap;

import com.mydeveloperplanet.myvalidationplanet.domain.Customer;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
class CustomerValidatedService {

    private final HashMap<Long, Customer> customers = new HashMap<>();
    private Long index = 0L;

    Customer createCustomer(@Valid Customer customer) {
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
