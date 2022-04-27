package com.linkedin.network.api;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.response.*;
import com.linkedin.network.service.*;
import com.linkedin.network.util.*;

import io.micrometer.core.instrument.util.*;

@RestController
public class FeedController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	FeedService feedService;

	/**
	 * This method Fetch the Feeds based on the Linkedin User
	 *
	 * @param userId
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/feed")
	public ResponseEntity<ApiResponse> fetchFeedTmp(@RequestParam String userId) throws JsonProcessingException {
		log.info("Fetch Feed from Linkedin Professional Networking  ");
		ApiResponse apiResponse = new ApiResponse();
		if (StringUtils.isNotBlank(userId)) {
			List<Feed> lstFeed = feedService.fetchFeedByUserId(userId);
			apiResponse.setResponse(lstFeed);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("Success");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.EMPTY_USER_REQUEST);
		}
		return ResponseEntity.ok().body(apiResponse);
	}

	/**
	 * This method Create the Feeds based on the Linkedin User
	 *
	 * @param feedRequest
	 * @return
	 * @throws JsonProcessingException
	 */
	@PostMapping(value = "/createFeed")
	public ResponseEntity<ApiResponse> createFeed(@RequestBody FeedRequest feedRequest) throws JsonProcessingException {
		log.info("Create Feed from Linkedin Professional Networking  ");
		ApiResponse apiResponse = new ApiResponse();
		if (feedRequest != null && StringUtils.isNotBlank(feedRequest.getUserId())) {
			List<Feed> lstFeed = feedService.createFeedForUser(feedRequest);
			apiResponse.setResponse(lstFeed);
			apiResponse.setStatus(HttpStatus.OK.toString());
			apiResponse.setMessage("Success");
		} else {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
		}
		return ResponseEntity.ok().body(apiResponse);
	}

}
