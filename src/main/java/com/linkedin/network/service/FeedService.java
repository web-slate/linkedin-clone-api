package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

public interface FeedService {

	public List<Feed> fetchFeedByUserId(String userId);

	List<Feed> createFeedForUser(FeedRequest feedRequest);
}
