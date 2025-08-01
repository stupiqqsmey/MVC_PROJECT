package kh.edu.repository;

import kh.edu.model.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    List <Customer>  getByEmail(String email);

}

