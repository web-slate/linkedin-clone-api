package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.stereotype.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.mapper.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	private final ProfileRepository profileRepository;

	public ConnectionServiceImpl(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public List<ProfileDTO> getConnections() {
		List<Profile> profileList = profileRepository.findAllActiveUsers(true);
		return ProfileMapper.INSTANCE.toDtoList(profileList);
	}
}
