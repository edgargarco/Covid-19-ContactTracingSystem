package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;

@Entity
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String validationCode;
    private boolean isAuthenticated;
    @OneToOne
    private GenericUser genericUser;

    public UserCredential() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public GenericUser getGenericUser() {
        return genericUser;
    }

    public void setGenericUser(GenericUser genericUser) {
        this.genericUser = genericUser;
    }
}
