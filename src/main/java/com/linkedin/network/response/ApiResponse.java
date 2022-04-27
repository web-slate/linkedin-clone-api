package com.linkedin.network.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
