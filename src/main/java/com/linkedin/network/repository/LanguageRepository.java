package com.linkedin.network.repository;

import com.linkedin.network.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    public List<Language> findByUserId(String userId);
}
