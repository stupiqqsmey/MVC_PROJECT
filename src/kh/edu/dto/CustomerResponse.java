package kh.edu.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerResponse {
    private final Integer id;
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    private final String gender;
    private final Date dob;
    private final String companyName;
    private final BigDecimal monthlyIncome;
    private final Boolean isDeleted;

    public CustomerResponse(Integer id, String fullName, String email, String phone,
                            String gender, Date dob, String companyName,
                            BigDecimal monthlyIncome, Boolean isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phone;
        this.gender = gender;
        this.dob = dob;
        this.companyName = companyName;
        this.monthlyIncome = monthlyIncome;
        this.isDeleted = isDeleted;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }
}
