package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.EducationRequest;
import com.linkedin.ProfessionalNetworking.model.Education;

import java.util.List;

public interface EducationService {
    List<Education> getEducationByUserId(String userId);
    List<Education> createEducation(EducationRequest educationRequest);
}
