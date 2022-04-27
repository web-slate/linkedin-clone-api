package com.linkedin.network.repository;

import com.linkedin.network.entity.Feed;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFeedRepository extends JpaRepository<Feed,Long>{

    public List<Feed> findByUserId(String userId);
}
