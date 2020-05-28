package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
