package com.linkedin.network.dto;

import lombok.Data;

@Data
public class EducationRequest {
    public String userId;
    public String school;
    public String degree;
    public String fieldOfStudy;
    public String startMonth;
    public String startYear;
    public String endMonth;
    public String endYear;
}
