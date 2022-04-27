package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
	public List<Skills> findByUserId(String userId);
}
