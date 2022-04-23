package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.LanguageRequest;
import com.linkedin.ProfessionalNetworking.model.Experience;
import com.linkedin.ProfessionalNetworking.model.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getLanguageByUserId(String userId);
    List<Language> createLanguage(LanguageRequest languageRequest);
    Language updateLanguageByLanguageId(LanguageRequest languageRequest);
}
