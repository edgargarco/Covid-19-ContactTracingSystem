package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.UserRole;
import com.project.covid.ContactTracingSystem.repository.UserRoleRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class UserRoleService implements ICrudOperation<UserRole,Long> {
    private UserRoleRepository userRoleRepository;
    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole createOrUpdate(UserRole entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        UserRole userRole = userRoleRepository.findById(aLong).orElse(null);
        if(userRole != null){
            userRoleRepository.delete(userRole);
        }else {
            Logger.getInstance().getLog(UserRoleService.class).error("USER ROLE ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(Long aLong) {
        return userRoleRepository.findById(aLong).orElse(null);
    }
}
