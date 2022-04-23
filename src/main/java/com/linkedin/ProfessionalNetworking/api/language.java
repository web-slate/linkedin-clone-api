package com.linkedin.ProfessionalNetworking.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.ProfessionalNetworking.dto.LanguageRequest;
import com.linkedin.ProfessionalNetworking.model.Language;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.service.LanguageService;
import com.linkedin.ProfessionalNetworking.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class language {

    @Autowired
    LanguageService languageService;

    @GetMapping(value = "/language/{userId}")
    public ResponseEntity<ApiResponse> getLanguageByUserId(@PathVariable String userId) {
        ApiResponse apiResponse = new ApiResponse();
        if (userId != null) {
            List<Language> foundLanguage = languageService.getLanguageByUserId(userId);
            if (foundLanguage != null && !foundLanguage.isEmpty()) {
                apiResponse.setResponse(foundLanguage);
                apiResponse.setStatus(HttpStatus.OK.toString());
                apiResponse.setMessage("Found Language");
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

    @PostMapping(value = "/language")
    public ResponseEntity<ApiResponse> createLanguage(@RequestBody LanguageRequest languageRequest) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse();

        if (languageRequest != null && StringUtils.isNotBlank(languageRequest.getUserId())) {
            List<Language> newLanguage = languageService.createLanguage(languageRequest);
            apiResponse.setResponse(newLanguage);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("new language created");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping(value = "/language")
    public ResponseEntity<ApiResponse> updateLanguageById(@RequestBody LanguageRequest languageRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();

        if (languageRequest != null) {
            Language updatedLanguage = languageService.updateLanguageByLanguageId(languageRequest);
            apiResponse.setResponse(updatedLanguage);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("updated language");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }
}
