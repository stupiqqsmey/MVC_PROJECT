package kh.edu.view;

import kh.edu.dto.CustomerResponse;
import java.util.List;

public class CustomerView {
    public void displayCustomersAsTable(List<CustomerResponse> customers) {
        if (customers == null || customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.printf(
                "%-5s %-20s %-25s %-15s %-10s %-12s %-20s %-12s %-10s\n",
                "ID", "Full Name", "Email", "Phone", "Gender", "DOB", "Company", "Income", "Deleted"
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (CustomerResponse c : customers) {
            System.out.printf(
                    "%-5d %-20s %-25s %-15s %-10s %-12s %-20s %-12s %-10s\n",
                    c.getUuid(),
                    c.getFullName(),
                    c.getEmail(),
                    c.getPhone(),
                    c.getGender(),
                    c.getDob() != null ? c.getDob().toString() : "-",
                    c.getCompanyName() != null ? c.getCompanyName() : "-",
                    c.getMonthlyIncome() != null ? c.getMonthlyIncome().toString() : "-",
                    c.getIsDeleted() ? "Yes" : "No"
            );
        }
    }
}
