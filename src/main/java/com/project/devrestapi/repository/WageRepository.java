package com.project.devrestapi.repository;

import com.project.devrestapi.model.Wage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WageRepository extends JpaRepository<Wage, Long> {
}
