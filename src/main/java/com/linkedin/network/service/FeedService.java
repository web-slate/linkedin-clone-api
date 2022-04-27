package com.linkedin.network.service;

import com.linkedin.network.dto.FeedRequest;
import com.linkedin.network.entity.Feed;

import java.util.List;

public interface FeedService {

    public List<Feed> fetchFeedByUserId(String userId);

    List<Feed> createFeedForUser(FeedRequest feedRequest);
}

