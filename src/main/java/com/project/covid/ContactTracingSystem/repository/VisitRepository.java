package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Visit;
import com.project.covid.ContactTracingSystem.services.common.IOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {
}
