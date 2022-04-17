package com.linkedin.ProfessionalNetworking.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.ProfessionalNetworking.dto.ExperienceRequest;
import com.linkedin.ProfessionalNetworking.model.Experience;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.service.ExperienceService;
import com.linkedin.ProfessionalNetworking.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class experience {

    @Autowired
    ExperienceService experienceService;

    @PostMapping(value = "/experience")
    public ResponseEntity<ApiResponse> createExperience(@RequestBody ExperienceRequest experienceRequest) throws JsonProcessingException {
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
}
