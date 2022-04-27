package com.linkedin.network.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.network.dto.EducationRequest;
import com.linkedin.network.entity.Education;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.EducationService;
import com.linkedin.network.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<ApiResponse> createEducation(@RequestBody EducationRequest educationRequest) throws JsonProcessingException {
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
