package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Visit;
import com.project.covid.ContactTracingSystem.repository.VisitRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class VisitService implements ICrudOperation<Visit, Long> {
    private VisitRepository visitRepository;
@Autowired
    public void setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit createOrUpdate(Visit entity) {
        return visitRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Visit visit = visitRepository.findById(aLong).orElse(null);
        if (visit != null){
            visitRepository.delete(visit);
        }else {
            Logger.getInstance().getLog(VisitService.class).error("VISIT ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }
}
