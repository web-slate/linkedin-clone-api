package com.linkedin.network.service;
import com.linkedin.network.dto.SkillsDTO;
import com.linkedin.network.dto.SkillsRequest;
import com.linkedin.network.entity.Skills;

import java.util.List;

public interface SkillsService {
    List<SkillsDTO> getSkillsByUserId(String userId);
    Skills newSkill(SkillsRequest skillsRequest);
}
