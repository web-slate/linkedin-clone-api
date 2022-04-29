package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

public interface ProfileService {

	ProfileDTO getProfileByUserId(String userId);

    Profile updateProfileByProfileId(ProfileRequest profileRequest);

    List<Profile> createProfileForUser(ProfileRequest profileRequest);
}
