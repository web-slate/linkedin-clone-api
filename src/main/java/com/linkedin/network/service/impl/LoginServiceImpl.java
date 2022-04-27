package com.linkedin.network.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.linkedin.network.entity.*;
import com.linkedin.network.repository.*;
import com.linkedin.network.service.*;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginUserRepository loginUserRepository;

	@Override
	public List<LoginUser> checkUserLogin(String userId, String password) {
		return loginUserRepository.findByUserIdAndPassword(userId, password);

	}
}
