package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Privilege;
import com.project.covid.ContactTracingSystem.repository.PrivilegeRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class PrivilegeService implements ICrudOperation<Privilege, Long> {
    private PrivilegeRepository privilegeRepository;
    @Autowired
    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege createOrUpdate(Privilege entity) {
        return privilegeRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Privilege privilege = privilegeRepository.findById(aLong).orElse(null);
        if (privilege != null){
            privilegeRepository.delete(privilege);
        }else {
            Logger.getInstance().getLog(PrivilegeService.class).error("PRIVILEGE ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    @Override
    public Privilege findById(Long aLong) {
        return privilegeRepository.findById(aLong).orElse(null);
    }

    public List<Privilege> findThreePrivileges(String privilege_1,String privilege_2,String privilege_3){
        return privilegeRepository.findThreePrivileges(privilege_1,privilege_2,privilege_3);
    }
}
