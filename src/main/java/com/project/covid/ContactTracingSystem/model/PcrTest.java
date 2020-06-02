package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;

@Entity
public class PcrTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean test;
    private boolean status;
    @OneToOne(mappedBy = "test")
    private HealthStatus healthStatus;

    public PcrTest() {
    }

    public PcrTest(boolean test, boolean status) {
        this.test = test;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }
}
