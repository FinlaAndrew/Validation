package com.UST.EmployeeformPractice.repository;

import com.UST.EmployeeformPractice.entity.EntityPractice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoPractice extends JpaRepository<EntityPractice, Long> {
    Optional<EntityPractice> findByName(String name);
}
