package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HealthStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private GenericUser genericUser;
    @OneToOne
    private PcrTest test;
    private Date statusDate;
    private boolean fever;
    private boolean cough;
    private boolean breathDifficulty;
    private boolean soreThroat;
    private boolean smellLoss;
    private boolean tasteLoss;

    public HealthStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenericUser getGenericUser() {
        return genericUser;
    }

    public void setGenericUser(GenericUser genericUser) {
        this.genericUser = genericUser;
    }

    public PcrTest getTest() {
        return test;
    }

    public void setTest(PcrTest test) {
        this.test = test;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isBreathDifficulty() {
        return breathDifficulty;
    }

    public void setBreathDifficulty(boolean breathDifficulty) {
        this.breathDifficulty = breathDifficulty;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isSmellLoss() {
        return smellLoss;
    }

    public void setSmellLoss(boolean smellLoss) {
        this.smellLoss = smellLoss;
    }

    public boolean isTasteLoss() {
        return tasteLoss;
    }

    public void setTasteLoss(boolean tasteLoss) {
        this.tasteLoss = tasteLoss;
    }
}
