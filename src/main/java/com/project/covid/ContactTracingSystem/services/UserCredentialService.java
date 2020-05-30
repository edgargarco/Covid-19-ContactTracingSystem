package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.UserCredential;
import com.project.covid.ContactTracingSystem.repository.UserCredentialRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class UserCredentialService implements ICrudOperation<UserCredential, Long> {
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    public void setUserCredentialRepository(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public UserCredential createOrUpdate(UserCredential entity) {
        return userCredentialRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        UserCredential userCredential = userCredentialRepository.findById(aLong).orElse(null);
        if (userCredential != null){
            userCredentialRepository.delete(userCredential);
        }else {
            Logger.getInstance().getLog(UserCredentialService.class).error("USER CREDENTIAL ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<UserCredential> findAll() {
        return userCredentialRepository.findAll();
    }

    @Override
    public UserCredential findById(Long aLong) {
        return userCredentialRepository.findById(aLong).orElse(null);
    }
}
