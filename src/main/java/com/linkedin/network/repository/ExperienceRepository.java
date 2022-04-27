package com.linkedin.network.repository;

import com.linkedin.network.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    public List<Experience> findByUserId(String userId);
}
