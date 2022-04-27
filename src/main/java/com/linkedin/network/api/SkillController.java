package com.linkedin.network.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.response.*;
import com.linkedin.network.service.*;
import com.linkedin.network.util.*;

import io.micrometer.core.instrument.util.*;

@RestController
public class SkillController {

	@Autowired
	public SkillsService skillsService;

	@GetMapping(value = "/skills/{userId}")
	public ResponseEntity<ApiResponse> getSkillsByUserId(@PathVariable String userId) {
		ApiResponse apiResponse = new ApiResponse();
		if (userId != null) {
			List<Skills> foundSkills = skillsService.getSkillsByUserId(userId);
			if (foundSkills != null) {
				apiResponse.setResponse(foundSkills);
				apiResponse.setStatus(HttpStatus.OK.toString());
				apiResponse.setMessage("Found SKills");
			} else {
				apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
				apiResponse.setMessage(Constants.USER_ID_NOT_EXIST);
			}
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}

		return ResponseEntity.ok().body(apiResponse);
	}

	@PostMapping(value = "/skills")
	public ResponseEntity<ApiResponse> newSkill(@RequestBody SkillsRequest skillsRequest)
			throws JsonProcessingException {
		ApiResponse apiResponse = new ApiResponse();

		if (skillsRequest != null && StringUtils.isNotBlank(skillsRequest.getUserId())) {
			Skills newSkill = skillsService.newSkill(skillsRequest);
			apiResponse.setResponse(newSkill);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("new skills created");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}
}
