package com.linkedin.network.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ExperienceRequest {
    @NotNull
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
