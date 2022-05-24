package com.linkedin.network.repository;


import com.linkedin.network.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser,String>{

    LoginUser findByUserIdAndPassword(String userId, String password);

}