import kh.edu.controller.CustomerController;
import kh.edu.dto.CustomerResponse;
import kh.edu.view.CustomerView;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String URL = "jdbc:postgresql://localhost:5432/baking_system";
//        String USER = "postgres";
//        String PASSWORD = "smey12345";
//        String select = "SELECT * FROM customers";
//
//
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(select);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            System.out.println(" Connected and selected data from the database successfully!");
//
//            // Process the result set
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String fullName = resultSet.getString("full_name");
//                String gender = resultSet.getString("gender");
//                String dob = resultSet.getString("dob");
//                String email = resultSet.getString("email");
//                String phoneNumber = resultSet.getString("phone_number");
//                String address = resultSet.getString("address");
//
//                System.out.println("ID: " + id);
//                System.out.println("Full Name: " + fullName);
//                System.out.println("Gender: " + gender);
//                System.out.println("Date of Birth: " + dob);
//
//                System.out.println("Email: " + email);
//                System.out.println("Phone Number: " + phoneNumber);
//                System.out.println("Address: " + address);
//                System.out.println("------------------------");
//            }
//
//        } catch (SQLException e) {
//            System.err.println(" Connection or query failed: " + e.getMessage());
//        }




        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView();

        List<CustomerResponse> customers = controller.getAllCustomers();

        view.displayMenu();
    }
}
