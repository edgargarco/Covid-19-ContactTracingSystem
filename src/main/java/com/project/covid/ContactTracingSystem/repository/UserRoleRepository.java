package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
