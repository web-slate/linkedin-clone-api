package com.linkedin.network.repository;


import com.linkedin.network.model.LoginUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginUserRepository extends JpaRepository<LoginUser,String>{

    List<LoginUser> findByUserIdAndPassword(String userId, String password);

}