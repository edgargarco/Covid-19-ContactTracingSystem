package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.PcrTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcrTestRepository extends JpaRepository<PcrTest,Long> {
}
