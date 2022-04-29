package com.linkedin.network.service;

import com.linkedin.network.dto.ProfileRequest;
import com.linkedin.network.entity.Profile;

import java.util.List;

public interface ProfileService {

    Profile getProfileByUserId(String userId);
    Profile updateProfileByProfileId(ProfileRequest profileRequest);
    List<Profile> createProfileForUser(ProfileRequest profileRequest);
}
