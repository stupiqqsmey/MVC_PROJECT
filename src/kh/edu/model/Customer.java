package kh.edu.model;

import java.math.BigDecimal;
import java.util.Date;

public class Customer {
    private Integer id; // maps to 'id' in DB
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date dob;
    private String position;
    private String remarks;
    private String companyName;
    private String employmentType;
    private String mainSourceIncome;
    private BigDecimal monthlyIncome;
    private String address;
    private String cityOrProvince;
    private String country;
    private String zipCode;
    private Boolean isDeleted;
    private Integer customerSegmentId;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getMainSourceIncome() {
        return mainSourceIncome;
    }

    public void setMainSourceIncome(String mainSourceIncome) {
        this.mainSourceIncome = mainSourceIncome;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityOrProvince() {
        return cityOrProvince;
    }

    public void setCityOrProvince(String cityOrProvince) {
        this.cityOrProvince = cityOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCustomerSegmentId() {
        return customerSegmentId;
    }

    public void setCustomerSegmentId(Integer customerSegmentId) {
        this.customerSegmentId = customerSegmentId;
    }
}
