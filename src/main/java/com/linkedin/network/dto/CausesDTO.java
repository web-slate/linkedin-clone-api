package com.linkedin.network.dto;

import lombok.Data;

@Data
public class CausesDTO {
    private String userId;
    private String cause;
    private Long causeIdentifier;
}
