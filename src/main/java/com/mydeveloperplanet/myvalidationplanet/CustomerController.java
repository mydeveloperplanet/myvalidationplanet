package com.mydeveloperplanet.myvalidationplanet;

import com.mydeveloperplanet.myvalidationplanet.api.CustomerApi;
import com.mydeveloperplanet.myvalidationplanet.model.Customer;
import com.mydeveloperplanet.myvalidationplanet.model.CustomerFullData;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerFullData> createCustomer(Customer apiCustomer) {
        com.mydeveloperplanet.myvalidationplanet.domain.Customer customer = new com.mydeveloperplanet.myvalidationplanet.domain.Customer();
        customer.setFirstName(apiCustomer.getFirstName());
        customer.setLastName(apiCustomer.getLastName());

        return ResponseEntity.ok(domainToApi(customerService.createCustomer(customer)));
    }

    @Override
    public ResponseEntity<CustomerFullData> getCustomer(Long customerId) {
        com.mydeveloperplanet.myvalidationplanet.domain.Customer customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok(domainToApi(customer));
    }

    private CustomerFullData domainToApi(com.mydeveloperplanet.myvalidationplanet.domain.Customer customer) {
        CustomerFullData cfd = new CustomerFullData();
        cfd.setCustomerId(customer.getCustomerId());
        cfd.setFirstName(JsonNullable.of(customer.getFirstName()));
        cfd.setLastName(JsonNullable.of(customer.getLastName()));
        return cfd;
    }

}
