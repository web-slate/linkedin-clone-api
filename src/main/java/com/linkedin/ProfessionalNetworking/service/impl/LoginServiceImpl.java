package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.model.LoginUser;
import com.linkedin.ProfessionalNetworking.repository.LoginUserRepository;
import com.linkedin.ProfessionalNetworking.repository.UserFeedRepository;
import com.linkedin.ProfessionalNetworking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginUserRepository loginUserRepository;

    @Override
    public List<LoginUser> checkUserLogin(String userId, String password) {
        return loginUserRepository.findByUserIdAndPassword(userId, password);

    }
}
