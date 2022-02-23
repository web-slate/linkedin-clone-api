package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.FeedRequest;
import com.linkedin.ProfessionalNetworking.model.Feed;
import com.linkedin.ProfessionalNetworking.repository.UserFeedRepository;
import com.linkedin.ProfessionalNetworking.service.FeedService;
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
