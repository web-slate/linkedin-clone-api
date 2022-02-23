package com.linkedin.ProfessionalNetworking.repository;

import com.linkedin.ProfessionalNetworking.model.Feed;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFeedRepository extends JpaRepository<Feed,Long>{

    public List<Feed> findByUserId(String userId);
}
