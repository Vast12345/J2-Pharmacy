package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class CreateCustomerUseCase {
    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) {
        customerService.createCustomer(customer);
    }
}
