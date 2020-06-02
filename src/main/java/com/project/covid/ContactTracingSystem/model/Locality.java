package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Locality extends SampleLocality{

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Node> nodes;
    @OneToMany
    private Collection<Visit> visits;

    public Locality() {
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }


    public Collection<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
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
}
