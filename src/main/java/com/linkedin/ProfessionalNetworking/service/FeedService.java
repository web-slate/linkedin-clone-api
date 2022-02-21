package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.FeedResponse;
import com.linkedin.ProfessionalNetworking.model.Feed;

import java.util.List;

public interface FeedService {

    public List<Feed> fetchFeedByUserId(String userId);

    List<Feed> createFeedForUser(FeedResponse feedRequest);
}

