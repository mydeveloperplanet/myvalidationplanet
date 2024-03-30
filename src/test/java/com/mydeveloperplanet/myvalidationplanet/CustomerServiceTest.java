package com.mydeveloperplanet.myvalidationplanet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mydeveloperplanet.myvalidationplanet.domain.Customer;

import jakarta.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void whenCreateCustomerIsInvalid_thenThrowsException() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("John who has a very long last name");

        assertThrows(ConstraintViolationException.class, () -> {
            customerService.createCustomer(customer);
        });
    }

    @Test
    void whenCreateCustomerIsValid_thenCustomerCreated() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");

        Customer customerCreated = customerService.createCustomer(customer);
        assertNotNull(customerCreated.getCustomerId());

    }
}
