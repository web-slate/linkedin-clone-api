package com.linkedin.network.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.network.dto.FeedRequest;
import com.linkedin.network.entity.Feed;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.FeedService;
import com.linkedin.network.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    FeedService feedService;

    /**
     * This method Fetch the Feeds based on the Linkedin User
     * @param userId
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/feed")
    public ResponseEntity<ApiResponse> fetchFeedTmp(@RequestParam String userId) throws JsonProcessingException {
        log.info("Fetch Feed from Linkedin Professional Networking  ");
        ApiResponse apiResponse = new ApiResponse();
        if( StringUtils.isNotBlank(userId)){
            List<Feed> lstFeed = feedService.fetchFeedByUserId(userId);
            apiResponse.setResponse(lstFeed);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Success");
        }else{
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
        }
        return ResponseEntity.ok().body(apiResponse);
    }


    /**
     * This method Create the Feeds based on the Linkedin User
     * @param feedRequest
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/createFeed")
    public ResponseEntity<ApiResponse> createFeed(@RequestBody FeedRequest feedRequest) throws JsonProcessingException {
        log.info("Create Feed from Linkedin Professional Networking  ");
        ApiResponse apiResponse = new ApiResponse();
        if(feedRequest != null && StringUtils.isNotBlank(feedRequest.getUserId())){
            List<Feed> lstFeed = feedService.createFeedForUser(feedRequest);
            apiResponse.setResponse(lstFeed);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Success");
        }else{
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
        }
        return ResponseEntity.ok().body(apiResponse);
    }





}
