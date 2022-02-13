package com.linkedin.ProfessionalNetworking.repository;

import com.linkedin.ProfessionalNetworking.model.Feed;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedRepository extends JpaRepository<Feed,String>{
}
