package com.project.covid.ContactTracingSystem.model;

import com.project.covid.ContactTracingSystem.model.enums.InstitutionType;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Institution extends SampleLocality{

    @OneToMany
    private Collection<GenericUser> genericUsers;
    @Enumerated(EnumType.STRING)
    private InstitutionType institution;

    public Institution() {
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getCellPhone() {
        return super.getCellPhone();
    }

    @Override
    public void setCellPhone(String cellPhone) {
        super.setCellPhone(cellPhone);
    }

    public Collection<GenericUser> getGenericUsers() {
        return genericUsers;
    }

    public void setGenericUsers(List<GenericUser> genericUsers) {
        this.genericUsers = genericUsers;
    }

    public InstitutionType getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionType institution) {
        this.institution = institution;
    }
}
