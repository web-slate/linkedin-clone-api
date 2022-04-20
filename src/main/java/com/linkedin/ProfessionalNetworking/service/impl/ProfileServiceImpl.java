package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.ProfileRequest;
import com.linkedin.ProfessionalNetworking.model.Profile;
import com.linkedin.ProfessionalNetworking.repository.ProfileRepository;
import com.linkedin.ProfessionalNetworking.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Profile getProfileByUserId(String userId) {
        return profileRepository.findByUserId(userId);
    }

    @Override
    public Profile updateProfileByProfileId(ProfileRequest updateProfilePayload) {
        Profile updatedProfile = new Profile();
        updatedProfile.setUserId(updateProfilePayload.getUserId());
        updatedProfile.setFirstName(updateProfilePayload.getFirstName());
        updatedProfile.setProfileId(updateProfilePayload.getProfileId());
        updatedProfile.setLastName(updateProfilePayload.getLastName());
        updatedProfile.setAdditionalName(updateProfilePayload.getAdditionalName());
        profileRepository.save(updatedProfile);
        return updatedProfile;
    }

    @Override
    public List<Profile> createProfileForUser(ProfileRequest profileRequest) {
        Profile profilePayload = new Profile();
        profilePayload.setUserId(profileRequest.getUserId());
        profilePayload.setFirstName(profileRequest.getFirstName());
        profilePayload.setLastName(profileRequest.getLastName());
        profilePayload.setAdditionalName(profileRequest.getAdditionalName());
        profileRepository.save(profilePayload);
        return null;
    }
}
