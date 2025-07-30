package kh.edu.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerResponse {
    private Integer uuid;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private Date dob;
    private String companyName;
    private BigDecimal monthlyIncome;
    private Boolean isDeleted;

    public CustomerResponse(Integer uuid, String fullName, String email, String phone,
                            String gender, Date dob, String companyName,
                            BigDecimal monthlyIncome, Boolean isDeleted) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.companyName = companyName;
        this.monthlyIncome = monthlyIncome;
        this.isDeleted = isDeleted;
    }

    // Getters
    public Integer getUuid() { return uuid; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public Date getDob() { return dob; }
    public String getCompanyName() { return companyName; }
    public BigDecimal getMonthlyIncome() { return monthlyIncome; }
    public Boolean getIsDeleted() { return isDeleted; }
}
