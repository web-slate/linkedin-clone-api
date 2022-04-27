package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

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
