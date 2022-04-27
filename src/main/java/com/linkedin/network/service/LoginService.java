package com.linkedin.network.service;

import com.linkedin.network.model.LoginUser;

import java.util.List;

public interface LoginService {

    public List<LoginUser> checkUserLogin(String userId, String password);
}
