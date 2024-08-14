package com.pharmacy.customer.domain.service;

import java.sql.Date;
import java.util.Optional;

import com.pharmacy.customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer Customer);
    Optional<Customer> findCustomer(String id);
    Optional<Customer> updateCustomer(String id, String name, String lastName, String email, Date birthdate, float lon, float latitud, String codeCityCustomer);
    void deleteCustomer(String id);
}
