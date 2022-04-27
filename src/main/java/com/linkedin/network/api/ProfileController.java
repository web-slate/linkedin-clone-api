package com.linkedin.network.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.linkedin.network.dto.*;
import com.linkedin.network.response.*;
import com.linkedin.network.service.*;
import com.linkedin.network.util.*;

import io.micrometer.core.instrument.util.*;

@RestController
public class ProfileController {

	@Autowired
	ProfileService profileService;

	@GetMapping(value = "/profile/{userId}")
	public ResponseEntity<ApiResponse> getProfileByUserId(@PathVariable String userId) throws JsonParseException {
		ApiResponse apiResponse = new ApiResponse();
		if (userId != null) {
			ProfileDTO foundProfile = profileService.getProfileByUserId(userId);
			if (foundProfile != null) {
				apiResponse.setResponse(foundProfile);
				apiResponse.setStatus(HttpStatus.OK.toString());
				apiResponse.setMessage("Found Profile");
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

	@PostMapping(value = "/profile")
	public ResponseEntity<ApiResponse> createProfile(@RequestBody ProfileRequest profileRequest)
			throws JsonParseException {
		ApiResponse apiResponse = new ApiResponse();
		if (profileRequest != null && StringUtils.isNotBlank(profileRequest.getUserId())) {
			List<ProfileDTO> newProfile = profileService.createProfileForUser(profileRequest);
			apiResponse.setResponse(newProfile);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("New Profile Created");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}

	@PutMapping(value = "/profile")
	public ResponseEntity<ApiResponse> updateProfile(@RequestBody ProfileRequest profileRequest)
			throws JsonParseException {
		ApiResponse apiResponse = new ApiResponse();
		if (profileRequest != null) {
			ProfileDTO profileToBeUpdated = profileService.updateProfileByProfileId(profileRequest);
			apiResponse.setResponse(profileToBeUpdated);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("Profile Updated");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}
}
