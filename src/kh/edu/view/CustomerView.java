package kh.edu.view;

import kh.edu.dto.CustomerResponse;
<<<<<<< HEAD
import java.util.List;

public class CustomerView {
=======

import java.util.List;
import java.util.Scanner;

public class CustomerView {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu(List<CustomerResponse> customers) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View All Customers");
            System.out.println("2. View Only Active Customers");
            System.out.println("3. View Only Deleted Customers");
            System.out.println("4. Search Customer by Name");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayCustomersAsTable(customers);
                    break;
                case "2":
                    displayCustomersAsTable(
                            customers.stream().filter(c -> !c.getIsDeleted()).toList()
                    );
                    break;
                case "3":
                    displayCustomersAsTable(
                            customers.stream().filter(CustomerResponse::getIsDeleted).toList()
                    );
                    break;
                case "4":
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine().toLowerCase();
                    displayCustomersAsTable(
                            customers.stream()
                                    .filter(c -> c.getFullName().toLowerCase().contains(name))
                                    .toList()
                    );
                    break;
                case "0":
                    System.out.println("Exiting menu...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

>>>>>>> 52a234e (get-jdbc)
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
