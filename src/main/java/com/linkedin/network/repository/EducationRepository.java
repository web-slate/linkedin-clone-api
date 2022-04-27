package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface EducationRepository extends JpaRepository<Education, Long> {
	public List<Education> findByUserId(String userId);
}
