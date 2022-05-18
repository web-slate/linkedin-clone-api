package com.linkedin.network.repository;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Profile findByUserId(String userId);

	Profile findByProfileId(String profileId);
}
