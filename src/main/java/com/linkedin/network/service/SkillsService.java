package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

public interface SkillsService {
	List<Skills> getSkillsByUserId(String userId);

	Skills newSkill(SkillsRequest skillsRequest);
}
