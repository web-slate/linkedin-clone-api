package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	public List<Experience> findByUserId(String userId);
}
