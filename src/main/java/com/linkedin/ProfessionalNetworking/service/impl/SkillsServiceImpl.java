package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.SkillsRequest;
import com.linkedin.ProfessionalNetworking.model.Skills;
import com.linkedin.ProfessionalNetworking.repository.SkillsRepository;
import com.linkedin.ProfessionalNetworking.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
