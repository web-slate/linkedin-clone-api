package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

public interface ExperienceService {

	List<Experience> getExperienceByUserId(String userId);

	Experience updateExperienceByExperienceId(ExperienceRequest experienceRequest);

	List<Experience> createExperience(ExperienceRequest experienceRequest);
}
