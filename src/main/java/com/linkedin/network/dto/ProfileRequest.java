package com.linkedin.network.dto;

import lombok.*;

@Data
public class ProfileRequest {

	public String firstName;

	public String lastName;

	public String additionalName;

	public String userId;

	public Long profileId;
}
