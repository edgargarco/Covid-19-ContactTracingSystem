package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}
