package com.linkedin.network.service.impl;

import com.linkedin.network.dto.EducationRequest;
import com.linkedin.network.entity.Education;
import com.linkedin.network.repository.EducationRepository;
import com.linkedin.network.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<Education> getEducationByUserId(String userId) {
        return educationRepository.findByUserId(userId);
    }

    @Override
    public List<Education> createEducation(EducationRequest educationRequest) {
        Education educationPayload = new Education();
        educationPayload.setUserId(educationRequest.getUserId());
        educationPayload.setSchool(educationRequest.getSchool());
        educationPayload.setDegree(educationRequest.getDegree());
        educationPayload.setFieldOfStudy(educationRequest.getFieldOfStudy());
        educationPayload.setStartMonth(educationRequest.getStartMonth());
        educationPayload.setStartYear(educationRequest.getStartYear());
        educationPayload.setEndMonth(educationRequest.getEndMonth());
        educationPayload.setEndYear(educationRequest.getEndYear());
        educationRepository.save(educationPayload);
      return null;
    }
}
