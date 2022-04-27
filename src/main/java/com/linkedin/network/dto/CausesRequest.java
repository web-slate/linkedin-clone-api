package com.linkedin.ProfessionalNetworking.dto;

import lombok.Data;

@Data
public class CausesRequest {
    public String userId;
    public String cause;
    public Long causeId;
}
