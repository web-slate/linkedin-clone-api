package com.linkedin.network.service.impl;

import com.linkedin.network.entity.LoginUser;
import com.linkedin.network.repository.LoginUserRepository;
import com.linkedin.network.service.LoginService;
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
