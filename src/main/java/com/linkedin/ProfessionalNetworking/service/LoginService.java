package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.model.LoginUser;

import java.util.List;

public interface LoginService {

    public List<LoginUser> checkUserLogin(String userId, String password);
}
