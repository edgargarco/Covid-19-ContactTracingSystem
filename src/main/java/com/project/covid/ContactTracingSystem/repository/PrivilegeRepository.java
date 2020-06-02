package com.project.covid.ContactTracingSystem.repository;

import com.project.covid.ContactTracingSystem.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    /**
     * This is a sample query to select 3 different privileges to assign it to new user
     * @param privilege_1
     * @param privilege_2
     * @param privilege_3
     * @return
     */
    @Query("SELECT u FROM Privilege u WHERE u.name = :privilege_1 OR u.name = :privilege_2 OR u.name = :privilege_3")
    List<Privilege> findThreePrivileges (@Param("privilege_1") String privilege_1, @Param("privilege_2") String privilege_2,
                                         @Param("privilege_3") String privilege_3);
}
