package kh.edu.dao;

import kh.edu.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> findAll();                    // Read all customers
    Optional<Customer> findById(int id);         // Read single customer by ID
    Optional<Customer> findByEmail(String email);// Read customer by email

    boolean save(Customer customer);             // Create new customer
    boolean update(Customer customer);           // Update existing customer
    boolean deleteById(int id);                  // Delete customer by ID

    boolean existsByEmail(String email);         // Check duplicate email
    boolean existsById(int id);                  // Check if ID exists
}
