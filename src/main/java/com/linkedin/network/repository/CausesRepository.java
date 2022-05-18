package com.linkedin.network.repository;

import com.linkedin.network.entity.Causes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CausesRepository extends JpaRepository<Causes, Long> {
    List<Causes> findByUserId(String userId);
}
