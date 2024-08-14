package com.pharmacy.customer.application;

import java.sql.Date;
import java.util.Optional;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;

public class UpdateCustomerUseCase {
    private final CustomerService customerService;

    public UpdateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute(String id, String name, String lastName, String email, Date birthate, Float lon, Float latitud, String codeCity) {
        return customerService.updateCustomer(id, name, lastName, email, birthate, lon, latitud, codeCity);
    }
}
