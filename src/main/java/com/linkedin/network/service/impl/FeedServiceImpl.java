package com.linkedin.network.service.impl;

import com.linkedin.network.dto.FeedRequest;
import com.linkedin.network.entity.Feed;
import com.linkedin.network.repository.UserFeedRepository;
import com.linkedin.network.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
