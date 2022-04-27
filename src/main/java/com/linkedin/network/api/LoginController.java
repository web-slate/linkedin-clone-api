package com.linkedin.network.api;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import com.linkedin.network.response.*;
import com.linkedin.network.service.*;
import com.linkedin.network.util.*;

@RestController
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/**
	 * @param login
	 * @return
	 * @throws JsonProcessingException
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<ApiResponse> login(@RequestBody Login login) throws JsonProcessingException {
		log.info("Login into Linkedin Professional Networking [{}]", login);
		ApiResponse apiResponse = new ApiResponse();

		if (login.getUserId() != null && login.getPassword() != null) {
			List<LoginUser> lstLoginUsr = loginService.checkUserLogin(login.getUserId(), login.getPassword());
			if (!lstLoginUsr.isEmpty()) {
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
