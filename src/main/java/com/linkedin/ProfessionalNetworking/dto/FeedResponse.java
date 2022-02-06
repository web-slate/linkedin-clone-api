package com.linkedin.ProfessionalNetworking.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeedResponse {

    public String legalName;

    public String occupation;

    public String companyName;

    public String feedMsg;

    public String totalLikes;

    public String totalComments;

    public List<String> comment = new ArrayList<>();

    public String feedId;


    public String connectionType;



}
