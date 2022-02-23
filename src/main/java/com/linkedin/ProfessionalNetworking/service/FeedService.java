package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.FeedRequest;
import com.linkedin.ProfessionalNetworking.model.Feed;

import java.util.List;

public interface FeedService {

    public List<Feed> fetchFeedByUserId(String userId);

    List<Feed> createFeedForUser(FeedRequest feedRequest);
}

