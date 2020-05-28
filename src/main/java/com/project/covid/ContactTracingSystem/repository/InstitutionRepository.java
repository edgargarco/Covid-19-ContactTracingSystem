package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}
