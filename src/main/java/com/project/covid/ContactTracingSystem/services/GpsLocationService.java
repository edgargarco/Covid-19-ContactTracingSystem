package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.GpsLocation;
import com.project.covid.ContactTracingSystem.repository.GpsLocationRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class GpsLocationService implements ICrudOperation<GpsLocation,Long> {
    private GpsLocationRepository gpsLocationRepository;
    @Autowired
    public void setGpsLocationRepository(GpsLocationRepository gpsLocationRepository) {
        this.gpsLocationRepository = gpsLocationRepository;
    }

    @Override
    public GpsLocation createOrUpdate(GpsLocation entity) {
        return gpsLocationRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        GpsLocation gpsLocation = gpsLocationRepository.findById(aLong).orElse(null);
        if (gpsLocation != null){
            gpsLocationRepository.delete(gpsLocation);
        }else {
            Logger.getInstance().getLog(GpsLocationService.class).error("Location ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<GpsLocation> findAll() {
        return gpsLocationRepository.findAll();
    }

    @Override
    public GpsLocation findById(Long aLong) {
        return gpsLocationRepository.findById(aLong).orElse(null);
    }
}
