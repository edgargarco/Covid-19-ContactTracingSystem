package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Collection<GenericUser> users;
    @ManyToMany
    private Collection<Privilege> privileges;

    public Role() {
    }
    public Role(String roleName){
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

    public Collection<GenericUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<GenericUser> genericUsers) {
        this.users = genericUsers;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
    public void setPrivilege(Privilege privilege){
        this.privileges.add(privilege);
    }
}
