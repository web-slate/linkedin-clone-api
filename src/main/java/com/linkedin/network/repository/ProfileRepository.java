package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Profile findByUserId(String userId);

	Profile findByProfileId(String profileId);

	@Query("select p from Profile p where p.active = :active")
	List<Profile> findAllActiveUsers(boolean active);
}
