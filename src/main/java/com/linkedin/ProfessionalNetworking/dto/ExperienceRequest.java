package com.linkedin.ProfessionalNetworking.dto;

import lombok.Data;

@Data
public class ExperienceRequest {
    public String userId;
    public String title;
    public String employmentType;
    public String companyName;
    public String location;
    public Boolean currentCompany;
    public String startDate;
    public String endDate;
    public String description;
    public Long experienceId;
}
