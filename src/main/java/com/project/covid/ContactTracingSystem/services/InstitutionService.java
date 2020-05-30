package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Institution;
import com.project.covid.ContactTracingSystem.repository.InstitutionRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class InstitutionService implements ICrudOperation<Institution,Long> {
    private InstitutionRepository institutionRepository;
    @Autowired
    public void setInstitutionRepository(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Institution createOrUpdate(Institution entity) {
        return institutionRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Institution institution = institutionRepository.findById(aLong).orElse(null);
        if (institution != null){
            institutionRepository.delete(institution);
        }else {
            Logger.getInstance().getLog(InstitutionService.class).error("Institution ID: "+ aLong+" DOES NOT EXIST");
        }

    }

    @Override
    public Collection<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution findById(Long aLong) {
        return institutionRepository.findById(aLong).orElse(null);
    }
}
