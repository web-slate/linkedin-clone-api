package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	UserFeedRepository userFeedRepository;

	@Override
	public List<Feed> fetchFeedByUserId(String userId) {
		return userFeedRepository.findByUserId(userId);
	}

	@Override
	public List<Feed> createFeedForUser(FeedRequest feedRequest) {
		Feed objFeed = new Feed();
		objFeed.setUserId(feedRequest.getUserId());
		objFeed.setComment(feedRequest.getComment());
		objFeed.setCompanyName(feedRequest.getCompanyName());
		objFeed.setFeedMsg(feedRequest.getText());
		objFeed.setConnectionType(feedRequest.getConnectionType());
		objFeed.setLegalName(feedRequest.getLegalName());
		objFeed.setCompanyName(feedRequest.getCompanyName());
		objFeed.setOccupation(feedRequest.getOccupation());
		objFeed.setTotalComments(feedRequest.getTotalComments());
		objFeed.setTotalLikes(feedRequest.getTotalLikes());
		userFeedRepository.save(objFeed);
		return null;
	}
}
