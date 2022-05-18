package com.linkedin.network.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.network.dto.CausesDTO;
import com.linkedin.network.dto.CausesRequest;
import com.linkedin.network.entity.Causes;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.CausesService;
import com.linkedin.network.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CausesController {

    @Autowired
    private CausesService causesService;

    @GetMapping(value = "profile/causes/{userId}")
    public ResponseEntity<ApiResponse> getCausesByUserId(@PathVariable String userId) {
        ApiResponse apiResponse = new ApiResponse();
        if (userId != null) {
            List<CausesDTO> foundCauses = causesService.getCausesByUserId(userId);
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
            Causes newCause = causesService.createCause(causesRequest);
            apiResponse.setResponse(newCause);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("new cause created");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping(value = "/profile/causes/{causeId}")
    public ResponseEntity<ApiResponse> updateCauseById(@PathVariable Long causeId, @RequestBody CausesRequest causesRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();

        if (causesRequest != null) {
            Causes updatedCause = causesService.updateCauseByCauseId(causeId, causesRequest);
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
