package com.linkedin.network.repository;

import com.linkedin.network.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    public List<Education> findByUserId(String userId);
}
