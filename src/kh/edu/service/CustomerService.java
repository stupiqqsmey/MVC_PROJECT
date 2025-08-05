package kh.edu.service;

import kh.edu.dto.CustomerResponse;
import kh.edu.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // Read
    List<CustomerResponse> getAllCustomerResponses();

    // Create
    void createCustomer(Customer customer);

    // Update
    void updateCustomer(Customer customer);

    // Delete (Soft delete)
    void deleteCustomerById(int id);

    // Find (Optional, for update/edit form)
    Optional<Customer> findCustomerById(int id);
}
