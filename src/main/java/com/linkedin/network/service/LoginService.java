package com.linkedin.network.service;

import java.util.*;

import com.linkedin.network.entity.*;

public interface LoginService {

	public List<LoginUser> checkUserLogin(String userId, String password);
}
