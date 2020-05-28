package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.GpsLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpsLocationRepository extends JpaRepository<GpsLocation,Long> {
}
