package kh.edu.dao.impl;

import kh.edu.config.DBConnection;
import kh.edu.dao.CustomerDao;
import kh.edu.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private final Connection conn;

    public CustomerDaoImpl() {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customers.add(extractCustomer(rs));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching all customers: " + e.getMessage());
        }

        return customers;
    }

    @Override
    public Optional<Customer> findById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractCustomer(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error finding customer by ID: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        String sql = "SELECT * FROM customers WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractCustomer(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error finding customer by email: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean save(Customer customer) {
        String sql = "INSERT INTO customers (full_name, email, phone_number, gender) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            setCustomerParams(ps, customer);
            ps.setBoolean(13, customer.getIsDeleted());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error saving customer: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        String sql = "UPDATE customers SET full_name = ?, email = ?, phone_number = ?, gender = ?" +
                "WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            setCustomerParams(ps, customer);
            ps.setBoolean(13, customer.getIsDeleted());
            ps.setInt(14, customer.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error updating customer: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "UPDATE customers SET is_deleted = true WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error deleting customer: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }

    @Override
    public boolean existsById(int id) {
        return findById(id).isPresent();
    }

    private Customer extractCustomer(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setFullName(rs.getString("full_name"));
        c.setEmail(rs.getString("email"));
        c.setPhoneNumber(rs.getString("phone_number"));
        c.setGender(rs.getString("gender"));
        c.setDob(rs.getDate("dob"));
        c.setPosition(rs.getString("position"));
        c.setRemarks(rs.getString("remarks"));
        c.setCompanyName(rs.getString("company_name"));
        c.setEmploymentType(rs.getString("employment_type"));
        c.setMainSourceIncome(rs.getString("main_source_income"));
        c.setMonthlyIncome(rs.getBigDecimal("monthly_income"));
        c.setAddress(rs.getString("address"));
        c.setIsDeleted(rs.getBoolean("is_deleted"));
        return c;
    }

    private void setCustomerParams(PreparedStatement ps, Customer c) throws SQLException {
        ps.setString(1, c.getFullName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getPhoneNumber());
        ps.setString(4, c.getGender());
        if (c.getDob() != null) {
            ps.setDate(5, new java.sql.Date(c.getDob().getTime()));
        } else {
            ps.setNull(5, Types.DATE);
        }
        ps.setString(6, c.getPosition());
        ps.setString(7, c.getRemarks());
        ps.setString(8, c.getCompanyName());
        ps.setString(9, c.getEmploymentType());
        ps.setString(10, c.getMainSourceIncome());
        if (c.getMonthlyIncome() != null) {
            ps.setBigDecimal(11, c.getMonthlyIncome());
        } else {
            ps.setNull(11, Types.NUMERIC);
        }
        ps.setString(12, c.getAddress());
    }
}
