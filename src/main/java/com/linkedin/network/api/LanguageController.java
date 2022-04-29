package com.linkedin.network.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.network.dto.LanguageRequest;
import com.linkedin.network.entity.Language;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.LanguageService;
import com.linkedin.network.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping(value = "/profile/languages/{userId}")
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

    @PostMapping(value = "/profile/languages")
    public ResponseEntity<ApiResponse> createLanguage(@RequestBody LanguageRequest languageRequest) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse();

        if (languageRequest != null && StringUtils.isNotBlank(languageRequest.getUserId())) {
            Language newLanguage = languageService.createLanguage(languageRequest);
            apiResponse.setResponse(newLanguage);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("new language created");
        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping(value = "/profile/languages/{languageId}")
    public ResponseEntity<ApiResponse> updateLanguageById(@PathVariable Long languageId,@RequestBody LanguageRequest languageRequest) throws JsonParseException {
        ApiResponse apiResponse = new ApiResponse();

        if (languageRequest != null) {
            Language updatedLanguage = languageService.updateLanguageByLanguageId(languageId,languageRequest);
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
