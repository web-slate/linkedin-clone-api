package com.linkedin.network.api;

import java.util.*;

import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.response.*;
import com.linkedin.network.service.*;

@RestController
public class ConnectionController {

	private final ConnectionService connectionService;

	public ConnectionController(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@GetMapping(value = "connections")
	public ResponseEntity<ApiResponse> getAllUsers() {
		ApiResponse apiResponse = new ApiResponse();
		List<ProfileDTO> connections = connectionService.getConnections();
		apiResponse.setResponse(connections);
		apiResponse.setMessage("Found Connections");
		if (!CollectionUtils.isEmpty(connections)) {
			apiResponse.setMessage("No active connections available");
		}
		return ResponseEntity.ok().body(apiResponse);
	}
}
