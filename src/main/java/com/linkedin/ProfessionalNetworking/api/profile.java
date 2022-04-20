package com.linkedin.ProfessionalNetworking.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.linkedin.ProfessionalNetworking.dto.ProfileRequest;
import com.linkedin.ProfessionalNetworking.model.Profile;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.service.ProfileService;
import com.linkedin.ProfessionalNetworking.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class profile {

    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/profile/{userId}")
    public ResponseEntity<ApiResponse> getProfileByUserId(@PathVariable String userId) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();
        if (userId != null) {
          Profile foundProfile = profileService.getProfileByUserId(userId);
          if (foundProfile != null) {
              apiResponse.setResponse(foundProfile);
              apiResponse.setStatus(HttpStatus.OK.toString());
              apiResponse.setMessage("Found Profile");
          } else {
              apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
              apiResponse.setMessage("User Id is not exist");
          }
        } else {
          apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
          apiResponse.setMessage("User Id parameter is missing");
        }

        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping(value = "/profile")
    public ResponseEntity<ApiResponse> createProfile(@RequestBody ProfileRequest profileRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();
        if(profileRequest != null && StringUtils.isNotBlank(profileRequest.getUserId())) {
            List<Profile> newProfile = profileService.createProfileForUser(profileRequest);
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
    public ResponseEntity<ApiResponse> updateProfile(@RequestBody ProfileRequest profileRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();
        if(profileRequest != null) {
            Profile profileToBeUpdated = profileService.updateProfileByProfileId(profileRequest);
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
