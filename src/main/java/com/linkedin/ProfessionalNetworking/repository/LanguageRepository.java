package com.linkedin.ProfessionalNetworking.repository;

import com.linkedin.ProfessionalNetworking.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    public List<Education> findByUserId(String userId);
}
