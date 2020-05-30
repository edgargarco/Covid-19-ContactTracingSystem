package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential,Long> {
}
