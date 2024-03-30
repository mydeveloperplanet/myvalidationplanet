package com.mydeveloperplanet.myvalidationplanet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mydeveloperplanet.myvalidationplanet.domain.Customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mvc;

    @Test
    void whenCreateCustomerIsInvalid_thenReturnBadRequest() throws Exception {
        String body = """
                {
                  "firstName": "John",
                  "lastName": "John who has a very long last name"
                }
                """;

        mvc.perform(post("/customer")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());

    }

    @Test
    void whenCreateCustomerIsValid_thenReturnOk() throws Exception {
        String body = """
                {
                  "firstName": "John",
                  "lastName": "Doe"
                }
                """;
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        when(customerService.createCustomer(any())).thenReturn(customer);

        mvc.perform(post("/customer")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isOk());

    }

    @Test
    void whenGetCustomerIsInvalid_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/customer/abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenGetCustomerIsValid_thenReturnOk() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        when(customerService.getCustomer(any())).thenReturn(customer);

        mvc.perform(get("/customer/1"))
                .andExpect(status().isOk());
    }

}
