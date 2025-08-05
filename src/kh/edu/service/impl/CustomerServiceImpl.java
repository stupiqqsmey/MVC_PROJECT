package kh.edu.service.impl;

import kh.edu.dao.CustomerDao;
import kh.edu.dao.impl.CustomerDaoImpl;
import kh.edu.dto.CustomerResponse;
import kh.edu.model.Customer;
import kh.edu.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao dao = new CustomerDaoImpl();

    @Override
    public List<CustomerResponse> getAllCustomerResponses() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> customers = dao.findAll();

        for (Customer c : customers) {
            responses.add(new CustomerResponse(
                    c.getId(),
                    c.getFullName(),
                    c.getEmail(),
                    c.getPhoneNumber(),
                    c.getGender(),
                    c.getDob(),
                    c.getCompanyName(),
                    c.getMonthlyIncome(),
                    c.getIsDeleted()
            ));
        }
        return responses;
    }

    @Override
    public void createCustomer(Customer customer) {
        if (dao.existsByEmail(customer.getEmail())) {
            System.out.println("❌ Email already exists!");
            return;
        }
        dao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (!dao.existsById(customer.getId())) {
            System.out.println("❌ Customer ID not found!");
            return;
        }
        dao.update(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        if (!dao.existsById(id)) {
            System.out.println("❌ Customer ID not found!");
            return;
        }
        dao.deleteById(id);
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return dao.findById(id);
    }
}
