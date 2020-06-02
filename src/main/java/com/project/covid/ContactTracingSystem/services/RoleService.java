package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Role;
import com.project.covid.ContactTracingSystem.repository.RoleRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class RoleService implements ICrudOperation<Role,Long> {
    private RoleRepository roleRepository;
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createOrUpdate(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Role role = roleRepository.findById(aLong).orElse(null);
        if(role != null){
            roleRepository.delete(role);
        }else {
            Logger.getInstance().getLog(RoleService.class).error("USER ROLE ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long aLong) {
        return roleRepository.findById(aLong).orElse(null);
    }
    public Role findByRoleName(String role){
        return roleRepository.findByRoleName(role);
    }
}
