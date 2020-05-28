package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepository extends JpaRepository<Locality,Long> {
}
