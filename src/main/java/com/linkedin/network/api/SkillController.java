package com.linkedin.network.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.network.dto.SkillsRequest;
import com.linkedin.network.entity.Skills;
import com.linkedin.network.dto.SkillsDTO;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.SkillsService;
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
public class SkillController {

    @Autowired
    public SkillsService skillsService;

    @GetMapping(value = "/skills/{userId}")
    public ResponseEntity<ApiResponse> getSkillsByUserId(@PathVariable String userId) {
        ApiResponse apiResponse = new ApiResponse();
        if (userId != null) {
            List<SkillsDTO> foundSkills = skillsService.getSkillsByUserId(userId);
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
    public ResponseEntity<ApiResponse> newSkill(@RequestBody SkillsRequest skillsRequest) throws JsonProcessingException {
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
