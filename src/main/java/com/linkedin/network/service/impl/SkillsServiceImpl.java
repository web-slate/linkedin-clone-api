package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

@Service
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	public SkillsRepository skillsRepository;

	@Override
	public List<Skills> getSkillsByUserId(String userId) {
		return skillsRepository.findByUserId(userId);
	}

	@Override
	public Skills newSkill(SkillsRequest skillsRequest) {
		Skills skillsPayload = new Skills();
		skillsPayload.setUserId(skillsRequest.getUserId());
		skillsPayload.setSkill(skillsRequest.getSkill());
		skillsRepository.save(skillsPayload);
		return skillsPayload;
	}
}
