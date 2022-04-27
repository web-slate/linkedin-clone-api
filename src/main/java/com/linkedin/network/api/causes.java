package com.linkedin.ProfessionalNetworking.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.ProfessionalNetworking.dto.CausesRequest;
import com.linkedin.ProfessionalNetworking.model.Causes;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.service.CausesService;
import com.linkedin.ProfessionalNetworking.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class causes {

    @Autowired
    CausesService causesService;

    @GetMapping(value = "profile/causes/{userId}")
    public ResponseEntity<ApiResponse> getCausesByUserId(@PathVariable String userId) {
        ApiResponse apiResponse = new ApiResponse();
        if (userId != null) {
            List<Causes> foundCauses = causesService.getCausesByUserId(userId);
            if (foundCauses != null && !foundCauses.isEmpty()) {
                apiResponse.setResponse(foundCauses);
                apiResponse.setStatus(HttpStatus.OK.toString());
                apiResponse.setMessage("Found Causes");
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

    @PostMapping(value = "/profile/causes")
    public ResponseEntity<ApiResponse> createCause(@RequestBody CausesRequest causesRequest) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse();

        if (causesRequest != null && StringUtils.isNotBlank(causesRequest.getUserId())) {
            List<Causes> newCause = causesService.createCause(causesRequest);
            apiResponse.setResponse(newCause);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("new cause created");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping(value = "/profile/causes")
    public ResponseEntity<ApiResponse> updateCauseById(@RequestBody CausesRequest causesRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();

        if (causesRequest != null) {
            Causes updatedCause = causesService.updateCauseByCauseId(causesRequest);
            apiResponse.setResponse(updatedCause);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("updated cause");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }
}
