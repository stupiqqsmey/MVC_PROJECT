package kh.edu.view;

import kh.edu.dto.CustomerResponse;
import kh.edu.model.Customer;
import kh.edu.service.CustomerService;
import kh.edu.service.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CustomerView {

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService service = new CustomerServiceImpl();

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== 📋 Customer Menu ===");
            System.out.println("1. View All Customers");
            System.out.println("2. View Only Active Customers");
            System.out.println("3. View Only Deleted Customers");
            System.out.println("4. Search Customer by Name");
            System.out.println("5. Search Customers by Email");
            System.out.println("6. Add New Customer");
            System.out.println("7. Update Customer");
            System.out.println("8. Delete Customer");
            System.out.println("0. Exit");
            System.out.print("🔢 Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> displayCustomers(service.getAllCustomerResponses());
                case "2" -> displayCustomers(service.getAllCustomerResponses().stream()
                        .filter(c -> !c.getIsDeleted()).toList());
                case "3" -> displayCustomers(service.getAllCustomerResponses().stream()
                        .filter(CustomerResponse::getIsDeleted).toList());
                case "4" -> searchCustomerByName();
                case "5" -> searchCustomerByEmail();
                case "6" -> addNewCustomer();
                case "7" -> updateCustomer();
                case "8" -> deleteCustomer();
                case "0" -> {
                    System.out.println("👋 Exiting menu...");
                    return;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    private void displayCustomers(List<CustomerResponse> customers) {
        if (customers == null || customers.isEmpty()) {
            System.out.println("⚠️ No customers found.");
            return;
        }

        System.out.printf("%-5s %-20s %-25s %-15s %-10s %-12s %-20s %-12s %-10s%n",
                "ID", "Full Name", "Email", "Phone", "Gender", "DOB", "Company", "Income", "Deleted");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (CustomerResponse c : customers) {
            System.out.printf("%-5d %-20s %-25s %-15s %-10s %-12s %-20s %-12s %-10s%n",
                    c.getId(),
                    c.getFullName(),
                    c.getEmail(),
                    c.getPhoneNumber(),
                    c.getGender(),
                    c.getDob() != null ? c.getDob().toString() : "-",
                    c.getCompanyName() != null ? c.getCompanyName() : "-",
                    c.getMonthlyIncome() != null ? c.getMonthlyIncome().toString() : "-",
                    c.getIsDeleted() ? "Yes" : "No"
            );
        }
    }

    private void searchCustomerByName() {
        System.out.print("🔍 Enter name to search: ");
        String name = scanner.nextLine().trim().toLowerCase();
        List<CustomerResponse> results = service.getAllCustomerResponses().stream()
                .filter(c -> c.getFullName().toLowerCase().contains(name))
                .toList();
        displayCustomers(results);
    }

    private void searchCustomerByEmail() {
        System.out.print("📧 Enter email to search: ");
        String email = scanner.nextLine().trim().toLowerCase();
        List<CustomerResponse> results = service.getAllCustomerResponses().stream()
                .filter(c -> c.getEmail().toLowerCase().contains(email))
                .toList();
        displayCustomers(results);
    }

    private void addNewCustomer() {
        try {
            Customer customer = new Customer();

            System.out.print("Full Name: ");
            customer.setFullName(scanner.nextLine().trim());

            System.out.print("Email: ");
            customer.setEmail(scanner.nextLine().trim());

            System.out.print("Phone Number: ");
            customer.setPhoneNumber(scanner.nextLine().trim());

            System.out.print("Gender: ");
            customer.setGender(scanner.nextLine().trim());

            customer.setIsDeleted(false);

            service.createCustomer(customer);
            System.out.println("✅ Customer added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
        }
    }

    private void updateCustomer() {
        try {
            System.out.print("Enter Customer ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            CustomerResponse existing = service.getAllCustomerResponses().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (existing == null) {
                System.out.println("❌ Customer not found.");
                return;
            }

            Customer customer = new Customer();
            customer.setId(id);

            System.out.printf("Full Name (%s): ", existing.getFullName());
            String fullName = scanner.nextLine().trim();
            customer.setFullName(fullName.isEmpty() ? existing.getFullName() : fullName);

            System.out.printf("Email (%s): ", existing.getEmail());
            String email = scanner.nextLine().trim();
            customer.setEmail(email.isEmpty() ? existing.getEmail() : email);

            System.out.printf("Phone (%s): ", existing.getPhoneNumber());
            String phoneNumber = scanner.nextLine().trim();
            customer.setPhoneNumber(phoneNumber.isEmpty() ? existing.getPhoneNumber() : phoneNumber);

            System.out.printf("Gender (%s): ", existing.getGender());
            String gender = scanner.nextLine().trim();
            customer.setGender(gender.isEmpty() ? existing.getGender() : gender);

            customer.setIsDeleted(existing.getIsDeleted());

            service.updateCustomer(customer);
            System.out.println("✅ Customer updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid ID.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
        }
    }

    private void deleteCustomer() {
        try {
            System.out.print("Enter Customer ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Confirm customer exists
            CustomerResponse existing = service.getAllCustomerResponses().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (existing == null) {
                System.out.println("❌ Customer not found.");
                return;
            }

            service.deleteCustomerById(id);
            System.out.println("✅ Customer deleted successfully!");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid ID.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
        }
    }
}
