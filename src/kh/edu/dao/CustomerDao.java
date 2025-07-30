package kh.edu.dao;

import kh.edu.model.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();
}
