package com.linkedin.network.repository;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	public Profile findByUserId(String userId);

	public Profile findByProfileId(String profileId);
}
