package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.GenericUser;
import com.project.covid.ContactTracingSystem.repository.GenericUserRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class GenericUserService implements ICrudOperation<GenericUser,Long> {
    private GenericUserRepository genericUserRepository;
    @Autowired
    public void setGenericUserRepository(GenericUserRepository genericUserRepository) {
        this.genericUserRepository = genericUserRepository;
    }

    @Override
    public GenericUser createOrUpdate(GenericUser entity) {
        return genericUserRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        GenericUser genericUser = genericUserRepository.findById(aLong).orElse(null);
        if (genericUser != null){
            genericUserRepository.delete(genericUser);
        }else {
            Logger.getInstance().getLog(GenericUserService.class).error("USER ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<GenericUser> findAll() {
        return genericUserRepository.findAll();
    }

    @Override
    public GenericUser findById(Long aLong) {
        return genericUserRepository.findById(aLong).orElse(null);
    }
}
