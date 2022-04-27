package com.linkedin.network.dto;

import javax.validation.constraints.*;

import lombok.*;

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
