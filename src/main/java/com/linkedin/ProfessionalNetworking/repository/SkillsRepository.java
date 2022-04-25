package com.linkedin.ProfessionalNetworking.repository;

import com.linkedin.ProfessionalNetworking.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    public List<Skills> findByUserId(String userId);
}
