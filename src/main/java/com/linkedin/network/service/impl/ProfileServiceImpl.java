package com.linkedin.network.service.impl;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.Profile;
import com.linkedin.network.mapper.*;
import com.linkedin.network.repository.ProfileRepository;
import com.linkedin.network.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public ProfileDTO getProfileByUserId(String userId) {
        Profile profile = profileRepository.findByUserId(userId);
        return ProfileMapper.INSTANCE.toDto(profile);
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
