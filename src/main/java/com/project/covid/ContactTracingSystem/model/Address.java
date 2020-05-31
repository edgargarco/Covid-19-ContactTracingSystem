package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direction;
    private String postalCode;
    private String city;
    private String country;
    @OneToOne(fetch = FetchType.LAZY)
    private GenericUser genericUser;

    public Address() {
    }
    public Address( String direction,String postalCode,String city,String country){

        this.direction = direction;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
