package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

public interface EducationService {
	List<Education> getEducationByUserId(String userId);

	List<Education> createEducation(EducationRequest educationRequest);
}
