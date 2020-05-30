package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Locality;
import com.project.covid.ContactTracingSystem.repository.LocalityRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class LocalityService implements ICrudOperation<Locality,Long> {
    private LocalityRepository localityRepository;
    @Autowired
    public void setLocalityRepository(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    public Locality createOrUpdate(Locality entity) {
        return localityRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Locality locality = localityRepository.findById(aLong).orElse(null);
        if (locality != null){
            localityRepository.delete(locality);
        }else {
            Logger.getInstance().getLog(LocalityService.class).error("LOCALITY ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Locality> findAll() {
        return localityRepository.findAll();
    }

    @Override
    public Locality findById(Long aLong) {
        return localityRepository.findById(aLong).orElse(null);
    }
}
