package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import javax.validation.constraints.Email;


public class SampleLocality {
    private String name;
    private Address address;
    private String email;
    private String cellPhone;

    public SampleLocality() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
