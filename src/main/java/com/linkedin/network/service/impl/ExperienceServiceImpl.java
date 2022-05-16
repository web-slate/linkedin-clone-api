package com.linkedin.network.service.impl;

import com.linkedin.network.dto.ExperienceDTO;
import com.linkedin.network.entity.Experience;
import com.linkedin.network.mapper.ExperienceMapper;
import com.linkedin.network.repository.ExperienceRepository;
import com.linkedin.network.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public List<ExperienceDTO> getExperienceByUserId(String userId) {
        List<Experience> experiences = experienceRepository.findByUserId(userId);
        return ExperienceMapper.INSTANCE.toDto(experiences);
    }

    @Override
    public Experience updateExperienceByExperienceId(ExperienceDTO experienceRequest) {
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
    public List<Experience> createExperience(ExperienceDTO experienceRequest) {
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
