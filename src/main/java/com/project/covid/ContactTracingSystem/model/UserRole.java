package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToMany
    private List<GenericUser> genericUsers;
    @ManyToMany
    private List<Privilege> privileges;

    public UserRole() {
    }
    public UserRole(String roleName){
        this.roleName = roleName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<GenericUser> getGenericUsers() {
        return genericUsers;
    }

    public void setGenericUsers(List<GenericUser> genericUsers) {
        this.genericUsers = genericUsers;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
    public void setPrivilege(Privilege privilege){
        this.privileges.add(privilege);
    }
}
