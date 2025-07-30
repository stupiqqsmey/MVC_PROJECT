package kh.edu.service.impl;

import kh.edu.dao.CustomerDao;
import kh.edu.dao.impl.CustomerDaoImpl;
import kh.edu.dto.CustomerResponse;
import kh.edu.model.Customer;
import kh.edu.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao dao = new CustomerDaoImpl();

    @Override
    public List<CustomerResponse> getAllCustomerResponses() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> customers = dao.findAll();

        for (Customer c : customers) {
            responses.add(new CustomerResponse(
                    c.getUuid(),
                    c.getFullName(),
                    c.getEmail(),
                    c.getPhone(),
                    c.getGender(),
                    c.getDob(),
                    c.getCompanyName(),
                    c.getMonthlyIncome(),
                    c.getIsDeleted()
            ));
        }

        return responses;
    }
}
