package com.linkedin.network.service;

import com.linkedin.network.dto.ExperienceDTO;
import com.linkedin.network.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<ExperienceDTO> getExperienceByUserId(String userId);

    Experience updateExperienceByExperienceId(ExperienceDTO experienceRequest);
    List<Experience> createExperience(ExperienceDTO experienceRequest);
}
