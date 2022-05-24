package com.linkedin.network.service;

import com.linkedin.network.entity.LoginUser;

public interface LoginService {

    public LoginUser checkUserLogin(String userId, String password);
}
