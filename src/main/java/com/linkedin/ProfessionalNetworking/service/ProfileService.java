package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.ProfileRequest;
import com.linkedin.ProfessionalNetworking.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> createProfileForUser(ProfileRequest profileRequest);
}
