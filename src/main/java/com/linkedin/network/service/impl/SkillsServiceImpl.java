package com.linkedin.network.service.impl;

import com.linkedin.network.dto.SkillsRequest;
import com.linkedin.network.model.Skills;
import com.linkedin.network.repository.SkillsRepository;
import com.linkedin.network.service.SkillsService;
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
