package com.linkedin.network.service;

import com.linkedin.network.dto.ExperienceRequest;
import com.linkedin.network.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getExperienceByUserId(String userId);

    Experience updateExperienceByExperienceId(ExperienceRequest experienceRequest);
    List<Experience> createExperience(ExperienceRequest experienceRequest);
}
