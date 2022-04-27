package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;

public interface ProfileService {

	ProfileDTO getProfileByUserId(String userId);

	ProfileDTO updateProfileByProfileId(ProfileRequest profileRequest);

	List<ProfileDTO> createProfileForUser(ProfileRequest profileRequest);
}
