package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthStatusRepository extends JpaRepository<HealthStatus,Long> {
}
