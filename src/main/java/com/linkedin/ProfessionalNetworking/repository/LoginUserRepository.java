package com.linkedin.ProfessionalNetworking.repository;


import com.linkedin.ProfessionalNetworking.model.LoginUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginUserRepository extends JpaRepository<LoginUser,String>{

    List<LoginUser> findByUserIdAndPassword(String userId, String password);

}