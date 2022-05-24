package com.linkedin.network.service.impl;

import com.linkedin.network.dto.SkillsDTO;
import com.linkedin.network.dto.SkillsRequest;
import com.linkedin.network.entity.Skills;
import com.linkedin.network.mapper.SkillMapper;
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
    public List<SkillsDTO> getSkillsByUserId(String userId) {
        List<Skills> skill = skillsRepository.findByUserId(userId);
        return SkillMapper.INSTANCE.toDto(skill);
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
