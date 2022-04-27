package com.linkedin.network.service;

import com.linkedin.network.dto.EducationRequest;
import com.linkedin.network.entity.Education;

import java.util.List;

public interface EducationService {
    List<Education> getEducationByUserId(String userId);
    List<Education> createEducation(EducationRequest educationRequest);
}
