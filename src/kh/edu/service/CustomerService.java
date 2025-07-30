package kh.edu.service;

import kh.edu.dto.CustomerResponse;
import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomerResponses();
}
