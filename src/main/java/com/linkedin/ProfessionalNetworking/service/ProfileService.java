package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.ProfileRequest;
import com.linkedin.ProfessionalNetworking.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile getProfileByUserId(String userId);
    Profile updateProfileByProfileId(ProfileRequest profileRequest);
    List<Profile> createProfileForUser(ProfileRequest profileRequest);
}
