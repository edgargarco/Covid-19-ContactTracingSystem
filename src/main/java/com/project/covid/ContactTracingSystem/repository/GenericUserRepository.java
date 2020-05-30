package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericUserRepository extends JpaRepository<GenericUser,Long> {
}
