package com.linkedin.network.response;

import java.io.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String status = Status.SUCCESS.name();
	private String message;
	private T response;

	public enum Status {
		SUCCESS, FAILED
	}

}
