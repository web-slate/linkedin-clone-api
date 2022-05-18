package com.linkedin.network.service;

import com.linkedin.network.dto.LanguageRequest;
import com.linkedin.network.entity.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getLanguageByUserId(String userId);
    Language createLanguage(LanguageRequest languageRequest);
    Language updateLanguageByLanguageId(Long languageId, LanguageRequest languageRequest);
}
