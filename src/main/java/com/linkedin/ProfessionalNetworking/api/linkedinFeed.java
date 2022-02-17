package com.linkedin.ProfessionalNetworking.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.ProfessionalNetworking.dto.FeedRequest;
import com.linkedin.ProfessionalNetworking.dto.FeedResponse;
import com.linkedin.ProfessionalNetworking.model.Feed;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.service.FeedService;
import com.linkedin.ProfessionalNetworking.util.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class linkedinFeed {

    private static final Logger log = LoggerFactory.getLogger(login.class);

    @Autowired
    FeedService feedService;

    /**
     * This method Fetch the Feeds based on the Linkedin User
     * @param feedRequest
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/fetchfeed")
    public ResponseEntity<ApiResponse> fetchFeedTmp(@RequestBody FeedRequest feedRequest) throws JsonProcessingException {
        log.info("Fetch Feed from Linkedin Professional Networking  ");
        ApiResponse apiResponse = new ApiResponse();
        if(feedRequest != null && StringUtils.isNotBlank(feedRequest.getUserId())){
            List<Feed> lstFeed = feedService.fetchFeedByUserId(feedRequest.getUserId());
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
     * This method Fetch the Feeds based on the Linkedin User
     * @param feedRequest
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/fetchfeed")
    public ResponseEntity<ApiResponse> createFeed(@RequestBody FeedResponse feedRequest) throws JsonProcessingException {
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

    @PostMapping(value = "/feed")
    public ResponseEntity<ApiResponse> fetchFeed(@RequestBody FeedRequest feedRequest) throws JsonProcessingException {
        log.info("Fetch Fee from Linkedin Professional Networking  ");
        ApiResponse apiResponse = new ApiResponse();
        //FIXME: Hardcoded values are to be replaced.

        if(feedRequest != null && StringUtils.isNotBlank(feedRequest.getUserId())){
            apiResponse.setResponse(testData());
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Success");
        }else{
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    /**
     * Test Data
     * @return
     */
    //FIXME: Remove the Method once connected DB
    public List<FeedResponse> testData(){
        List<FeedResponse> lstFeedResponse = new ArrayList<>();
        FeedResponse response = new FeedResponse();
        response.setLegalName("JP");
        response.setTotalComments("10");
        response.setTotalLikes("20");
        response.setFeedMsg("According to the report, the continued political instability caused the forecast for the investment segment in 2022 to be sluggish. Sluggish recovery is also expected for the retail and office sectors, leaving only the residential market for " +
                "bright recovery thanks to the property-related incentives under Budget 2022.");
        response.setCompanyName("ByteBrain Technologies");
        response.setOccupation("Technical Architect");
        lstFeedResponse.add(response);
        response = new FeedResponse();
        response.setLegalName("Udhay");
        response.setTotalComments("10");
        response.setTotalLikes("20");
        response.setFeedMsg("According to the report, the continued political instability caused the forecast for the investment segment in 2022 to be sluggish. Sluggish recovery is also expected for the retail and office sectors, leaving only the residential market for " +
                "bright recovery thanks to the property-related incentives under Budget 2022.");
        response.setCompanyName("DXC Technologies");
        response.setOccupation("Team Lead");
        lstFeedResponse.add(response);
        return lstFeedResponse;
    }

}
