package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
