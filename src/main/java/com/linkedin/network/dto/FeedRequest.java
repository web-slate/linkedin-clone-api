package com.linkedin.network.dto;

import lombok.Data;

@Data
public class FeedRequest {

    public String legalName;

    public String occupation;

    public String companyName;

    public String text;

    public String totalLikes;

    public String totalComments;

    public String comment ;

    public String feedId;

    public String connectionType;

    public String userId;
}
