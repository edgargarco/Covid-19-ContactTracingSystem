package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,Long> {
}
