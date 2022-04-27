package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepository experienceRepository;

	@Override
	public List<Experience> getExperienceByUserId(String userId) {
		return experienceRepository.findByUserId(userId);
	}

	@Override
	public Experience updateExperienceByExperienceId(ExperienceRequest experienceRequest) {
		Experience updatedExperience = new Experience();
		updatedExperience.setExperienceId(experienceRequest.getExperienceId());
		updatedExperience.setUserId(experienceRequest.getUserId());
		updatedExperience.setTitle(experienceRequest.getTitle());
		updatedExperience.setEmploymentType(experienceRequest.getEmploymentType());
		updatedExperience.setCompanyName(experienceRequest.getCompanyName());
		updatedExperience.setLocation(experienceRequest.getLocation());
		updatedExperience.setCurrentCompany(experienceRequest.getCurrentCompany());
		updatedExperience.setStartDate(experienceRequest.getStartDate());
		updatedExperience.setEndDate(experienceRequest.getEndDate());
		updatedExperience.setDescription(experienceRequest.getDescription());
		experienceRepository.save(updatedExperience);
		return updatedExperience;
	}

	@Override
	public List<Experience> createExperience(ExperienceRequest experienceRequest) {
		Experience experiencePayload = new Experience();
		experiencePayload.setUserId(experienceRequest.getUserId());
		experiencePayload.setTitle(experienceRequest.getTitle());
		experiencePayload.setEmploymentType(experienceRequest.getEmploymentType());
		experiencePayload.setCompanyName(experienceRequest.getCompanyName());
		experiencePayload.setLocation(experienceRequest.getLocation());
		experiencePayload.setCurrentCompany(experienceRequest.getCurrentCompany());
		experiencePayload.setStartDate(experienceRequest.getStartDate());
		experiencePayload.setEndDate(experienceRequest.getEndDate());
		experiencePayload.setDescription(experienceRequest.getDescription());
		experienceRepository.save(experiencePayload);
		return null;
	}
}
