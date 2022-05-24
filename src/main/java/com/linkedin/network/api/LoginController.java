package com.linkedin.network.api;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.linkedin.network.dto.Login;
import com.linkedin.network.entity.LoginUser;
import com.linkedin.network.response.ApiResponse;
import com.linkedin.network.service.LoginService;
import com.linkedin.network.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    LoginService loginService;

    /**
     *
     * @param login
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> login(@RequestBody Login login) throws JsonProcessingException {
        log.info("Login into Linkedin Professional Networking [{}]", login);
        ApiResponse apiResponse = new ApiResponse();

        if (login.getUserId() != null && login.getPassword() != null) {
            LoginUser loginUsr = loginService.checkUserLogin(login.getUserId(), login.getPassword());
            if (loginUsr!= null) {
                apiResponse.setStatus(HttpStatus.OK.toString());
                apiResponse.setMessage("Success");
            } else {
                apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
                apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
            }

        } else {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
        }
        return ResponseEntity.ok().body(apiResponse);
    }


}
