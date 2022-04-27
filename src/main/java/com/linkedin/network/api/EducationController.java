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
public class EducationController {

	@Autowired
	EducationService educationService;

	@GetMapping(value = "/education/{userId}")
	public ResponseEntity<ApiResponse> getEducationByUserId(@PathVariable String userId) {
		ApiResponse apiResponse = new ApiResponse();
		if (userId != null) {
			List<Education> foundEducation = educationService.getEducationByUserId(userId);
			if (foundEducation != null) {
				apiResponse.setResponse(foundEducation);
				apiResponse.setStatus(HttpStatus.OK.toString());
				apiResponse.setMessage("Found Education");
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

	@PostMapping(value = "/education")
	public ResponseEntity<ApiResponse> createEducation(@RequestBody EducationRequest educationRequest)
			throws JsonProcessingException {
		ApiResponse apiResponse = new ApiResponse();

		if (educationRequest != null && StringUtils.isNotBlank(educationRequest.getUserId())) {
			List<Education> newEducation = educationService.createEducation(educationRequest);
			apiResponse.setResponse(newEducation);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("new education created");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}
}
