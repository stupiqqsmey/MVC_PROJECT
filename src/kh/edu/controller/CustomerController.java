package kh.edu.controller;

import kh.edu.dto.CustomerResponse;
import kh.edu.service.CustomerService;
import kh.edu.service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private final CustomerService service = new CustomerServiceImpl();

    public List<CustomerResponse> getAllCustomers() {
        return service.getAllCustomerResponses();
    }
}
