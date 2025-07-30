package kh.edu.dao.impl;

import kh.edu.config.DBConnection;
import kh.edu.dao.CustomerDao;
import kh.edu.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();

<<<<<<< HEAD
                customer.setUuid(rs.getInt("id")); // in DB it's 'id'
=======
                customer.setId(rs.getInt("id")); // in DB it's 'id'
>>>>>>> 52a234e (get-jdbc)
                customer.setFullName(rs.getString("full_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone_number"));
                customer.setGender(rs.getString("gender"));
                customer.setDob(rs.getDate("dob"));
                customer.setPosition(rs.getString("position"));
                customer.setRemarks(rs.getString("remarks"));
                customer.setCompanyName(rs.getString("company_name"));
                customer.setEmploymentType(rs.getString("employment_type"));
                customer.setMainSourceIncome(rs.getString("main_source_income"));
                customer.setMonthlyIncome(rs.getBigDecimal("monthly_income"));
                customer.setAddress(rs.getString("address"));
                customer.setCityOrProvince(rs.getString("city_or_province"));
                customer.setCountry(rs.getString("country"));
                customer.setZipCode(rs.getString("zip_code"));
                customer.setIsDeleted(rs.getBoolean("is_deleted"));
                customer.setCustomerSegmentId(rs.getInt("customer_segment_id"));

                list.add(customer);
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            e.printStackTrace(); // Full error for debugging
=======
            e.getMessage();
>>>>>>> 52a234e (get-jdbc)
        }

        return list;
    }
}
