package com.linkedin.network.dto;

import lombok.Data;

@Data
public class LanguageRequest {
    public String userId;
    public String language;
    public String proficiency;
    public Long languageId;
}
