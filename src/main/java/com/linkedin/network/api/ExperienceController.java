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
public class ExperienceController {

	@Autowired
	ExperienceService experienceService;

	@GetMapping(value = "/experience/{userId}")
	public ResponseEntity<ApiResponse> getExperienceByUserId(@PathVariable String userId) {
		ApiResponse apiResponse = new ApiResponse();
		if (userId != null) {
			List<Experience> foundExperience = experienceService.getExperienceByUserId(userId);
			if (foundExperience != null && !foundExperience.isEmpty()) {
				apiResponse.setResponse(foundExperience);
				apiResponse.setStatus(HttpStatus.OK.toString());
				apiResponse.setMessage("Found Experience");
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

	@PostMapping(value = "/experience")
	public ResponseEntity<ApiResponse> createExperience(@RequestBody ExperienceRequest experienceRequest)
			throws JsonProcessingException {
		ApiResponse apiResponse = new ApiResponse();

		if (experienceRequest != null && StringUtils.isNotBlank(experienceRequest.getUserId())) {
			List<Experience> newExperience = experienceService.createExperience(experienceRequest);
			apiResponse.setResponse(newExperience);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("new experience created");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}

	@PutMapping(value = "/experience")
	public ResponseEntity<ApiResponse> updateExperienceById(@RequestBody ExperienceRequest experienceRequest)
			throws JsonParseException {
		ApiResponse apiResponse = new ApiResponse();

		if (experienceRequest != null) {
			Experience updatedExperience = experienceService.updateExperienceByExperienceId(experienceRequest);
			apiResponse.setResponse(updatedExperience);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("updated experience");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}
}
