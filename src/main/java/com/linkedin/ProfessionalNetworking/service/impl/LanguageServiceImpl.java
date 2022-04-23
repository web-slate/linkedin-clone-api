package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.LanguageRequest;
import com.linkedin.ProfessionalNetworking.model.Language;
import com.linkedin.ProfessionalNetworking.repository.LanguageRepository;
import com.linkedin.ProfessionalNetworking.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Language> getLanguageByUserId(String userId) {
        return languageRepository.findByUserId(userId);
    }

    @Override
    public List<Language> createLanguage(LanguageRequest languageRequest) {
        Language languagePayload = new Language();
        languagePayload.setUserId(languageRequest.getUserId());
        languagePayload.setLanguage(languageRequest.getLanguage());
        languagePayload.setProficiency(languageRequest.getProficiency());
        languageRepository.save(languagePayload);
      return null;
    }

    @Override
    public Language updateLanguageByLanguageId(LanguageRequest languageRequest) {
        Language updatedLanguage = new Language();
        updatedLanguage.setLanguage(updatedLanguage.getLanguage());
        updatedLanguage.setUserId(updatedLanguage.getUserId());
        updatedLanguage.setProficiency(updatedLanguage.getProficiency());
        languageRepository.save(updatedLanguage);
        return updatedLanguage;
    }
}
