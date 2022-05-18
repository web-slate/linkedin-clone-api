package com.linkedin.network.service.impl;

import com.linkedin.network.dto.LanguageRequest;
import com.linkedin.network.entity.Language;
import com.linkedin.network.repository.LanguageRepository;
import com.linkedin.network.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> getLanguageByUserId(String userId) {
        return languageRepository.findByUserId(userId);
    }

    @Override
    public Language createLanguage(LanguageRequest languageRequest) {
        Language languagePayload = new Language();
        languagePayload.setUserId(languageRequest.getUserId());
        languagePayload.setLanguage(languageRequest.getLanguage());
        languagePayload.setProficiency(languageRequest.getProficiency());
        languageRepository.save(languagePayload);
        return languagePayload;
    }

    @Override
    public Language updateLanguageByLanguageId(Long languageId, LanguageRequest languageRequest) {
        Optional<Language> existingLanguage = languageRepository.findById(languageId);
        if(existingLanguage.isPresent()){
            Language updateLanguage = existingLanguage.get();
            updateLanguage.setLanguage(languageRequest.getLanguage());
            updateLanguage.setUserId(languageRequest.getUserId());
            updateLanguage.setProficiency(languageRequest.getProficiency());
            languageRepository.save(updateLanguage);
        }
        return null;
    }
}
