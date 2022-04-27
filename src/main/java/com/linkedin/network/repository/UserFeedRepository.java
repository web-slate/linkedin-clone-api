package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface UserFeedRepository extends JpaRepository<Feed, Long> {

	public List<Feed> findByUserId(String userId);
}
