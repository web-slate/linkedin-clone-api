package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.ExperienceRequest;
import com.linkedin.ProfessionalNetworking.model.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getExperienceByUserId(String userId);

    Experience updateExperienceByExperienceId(ExperienceRequest experienceRequest);
    List<Experience> createExperience(ExperienceRequest experienceRequest);
}
