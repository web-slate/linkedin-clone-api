package com.linkedin.network.repository;

import com.linkedin.network.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    public List<Skills> findByUserId(String userId);
}
