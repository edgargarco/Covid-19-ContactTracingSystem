package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
