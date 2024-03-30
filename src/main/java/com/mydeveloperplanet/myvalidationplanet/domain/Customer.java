package com.mydeveloperplanet.myvalidationplanet.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Customer {
    private Long customerId;
    @Size(min = 1, max = 20)
    @NotEmpty
    private String firstName;
    @Size(min = 1, max = 20)
    @NotEmpty
    private String lastName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
