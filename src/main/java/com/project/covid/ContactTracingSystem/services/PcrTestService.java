package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.PcrTest;
import com.project.covid.ContactTracingSystem.repository.PcrTestRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class PcrTestService implements ICrudOperation<PcrTest ,Long> {
    private PcrTestRepository pcrTestRepository;
    @Autowired
    public void setPcrTestRepository(PcrTestRepository pcrTestRepository) {
        this.pcrTestRepository = pcrTestRepository;
    }

    @Override
    public PcrTest createOrUpdate(PcrTest entity) {
        return pcrTestRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        PcrTest pcrTest = pcrTestRepository.findById(aLong).orElse(null);
        if (pcrTest != null){
            pcrTestRepository.delete(pcrTest);
        }else{
            Logger.getInstance().getLog(PcrTestService.class).error("PCR TEST ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<PcrTest> findAll() {
        return pcrTestRepository.findAll();
    }

    @Override
    public PcrTest findById(Long aLong) {
        return pcrTestRepository.findById(aLong).orElse(null);
    }
}
