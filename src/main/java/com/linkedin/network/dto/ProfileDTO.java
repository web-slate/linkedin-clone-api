package com.linkedin.network.dto;

import java.util.*;

import lombok.*;

@Data
public class ProfileDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String additionalName;

    private String username;

    private String nickname;

    private Date birthday;

    private String phone;

    private String icon;

    private Integer gender;
}
