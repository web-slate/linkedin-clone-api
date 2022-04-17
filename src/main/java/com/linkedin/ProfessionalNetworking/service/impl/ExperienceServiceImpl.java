package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.ExperienceRequest;
import com.linkedin.ProfessionalNetworking.model.Experience;
import com.linkedin.ProfessionalNetworking.repository.ExperienceRepository;
import com.linkedin.ProfessionalNetworking.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

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
