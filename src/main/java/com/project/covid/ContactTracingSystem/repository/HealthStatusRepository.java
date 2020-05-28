package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthStatusRepository extends JpaRepository<HealthStatus,Long> {
}
