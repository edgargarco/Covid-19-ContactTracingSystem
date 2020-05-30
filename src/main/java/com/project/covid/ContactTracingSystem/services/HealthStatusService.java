package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.HealthStatus;
import com.project.covid.ContactTracingSystem.repository.HealthStatusRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Collection;
@Transactional
@Service
public class HealthStatusService implements ICrudOperation<HealthStatus,Long> {
    private HealthStatusRepository healthStatusRepository;
    @Autowired
    public void setHealthStatusRepository(HealthStatusRepository healthStatusRepository) {
        this.healthStatusRepository = healthStatusRepository;
    }

    @Override
    public HealthStatus createOrUpdate(HealthStatus entity) {
        return healthStatusRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        HealthStatus healthStatus = healthStatusRepository.findById(aLong).orElse(null);
        if (healthStatus != null){
            healthStatusRepository.delete(healthStatus);
        }else {
            Logger.getInstance().getLog(HealthStatusService.class).error("HEALTH STATUS ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<HealthStatus> findAll() {
        return healthStatusRepository.findAll();
    }

    @Override
    public HealthStatus findById(Long aLong) {
        return healthStatusRepository.findById(aLong).orElse(null);
    }
}
