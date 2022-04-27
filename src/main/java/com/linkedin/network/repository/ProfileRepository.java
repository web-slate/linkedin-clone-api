package com.linkedin.network.repository;

import com.linkedin.network.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    public Profile findByUserId(String userId);
    public Profile findByProfileId(String profileId);
}
