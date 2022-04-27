package com.linkedin.ProfessionalNetworking.repository;

import com.linkedin.ProfessionalNetworking.model.Causes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CausesRepository extends JpaRepository<Causes, Long> {
    public List<Causes> findByUserId(String userId);
}
