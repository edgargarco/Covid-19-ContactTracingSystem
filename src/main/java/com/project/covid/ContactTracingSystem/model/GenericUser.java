package com.project.covid.ContactTracingSystem.model;

import com.project.covid.ContactTracingSystem.model.enums.CivilStatus;
import com.project.covid.ContactTracingSystem.model.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity

public class GenericUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String personalIdentifier;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_credential_id ")
    private UserCredential userCredential;
    @Column(unique = true)
    private String email;
    private String cellPhone;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;
    private String occupation;
    @ManyToMany
    private Collection<Role> roles;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "generic_user_tag_id")
    private Tag tag;
    @CreationTimestamp
    private Date createdOn;
    @CreationTimestamp
    private Date tagGivenOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genericUserHealth")
    private Collection<HealthStatus> healthStatus;

    public GenericUser() {
    }



    public GenericUser(String firstName, String lastName, String personalIdentifier,
                         String email,
                       String cellPhone, Date birthDate, Gender gender, CivilStatus civilStatus,
                       String occupation ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdentifier = personalIdentifier;
        this.email = email;
        this.cellPhone = cellPhone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.occupation = occupation;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalIdentifier() {
        return personalIdentifier;
    }

    public void setPersonalIdentifier(String personalIdentifier) {
        this.personalIdentifier = personalIdentifier;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }



    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roleList) {
        this.roles = roleList;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getTagGivenOn() {
        return tagGivenOn;
    }

    public void setTagGivenOn(Date tagGivenOn) {
        this.tagGivenOn = tagGivenOn;
    }

    public Collection<HealthStatus> getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(List<HealthStatus> healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void addRole(Role role){
        if (roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }
}
