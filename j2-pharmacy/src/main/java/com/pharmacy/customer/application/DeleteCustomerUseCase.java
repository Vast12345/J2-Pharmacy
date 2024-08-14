package com.pharmacy.customer.application;

import com.pharmacy.customer.domain.service.CustomerService;

public class DeleteCustomerUseCase {
    private final CustomerService customerService;

    public DeleteCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(String id) {
        customerService.deleteCustomer(id);
    }
} 
