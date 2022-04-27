package com.linkedin.network.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.linkedin.network.entity.*;

public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

	List<LoginUser> findByUserIdAndPassword(String userId, String password);

}