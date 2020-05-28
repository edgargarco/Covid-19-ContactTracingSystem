package com.project.covid.ContactTracingSystem.model;

import com.project.covid.ContactTracingSystem.model.enums.InstitutionType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Institution extends SampleLocality{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<GenericUser> genericUsers;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GenericUser> getGenericUsers() {
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
