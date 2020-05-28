package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
