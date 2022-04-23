package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.SkillsRequest;
import com.linkedin.ProfessionalNetworking.model.Skills;

import java.util.List;

public interface SkillsService {
    List<Skills> getSkillsByUserId(String userId);
    List<Skills> createSkills(SkillsRequest skillsRequest);
}
