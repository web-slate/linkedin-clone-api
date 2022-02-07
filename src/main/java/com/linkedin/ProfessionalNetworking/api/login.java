package com.linkedin.ProfessionalNetworking.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.linkedin.ProfessionalNetworking.response.ApiResponse;
import com.linkedin.ProfessionalNetworking.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class login {

    private static final Logger log = LoggerFactory.getLogger(login.class);

    /**
     * This Method is used to check the Login of the application
     * @param userId
     * @param password
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> login(@RequestParam String userId, @RequestParam String password) throws JsonProcessingException {
        log.info("Login into Linkedin Professional Networking [{}]", userId, password);
        ApiResponse apiResponse = new ApiResponse();
        //FIXME: Hardcoded values are to be replaced.
       if(userId.equals("admin") && password.equals("admin")){
           apiResponse.setStatus(HttpStatus.OK.toString());
           apiResponse.setMessage("Success");
       }else{
           apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
           apiResponse.setMessage(Constants.INVALID_USERNAME_PASSWORD);
       }
        return ResponseEntity.ok().body(apiResponse);
    }


}
