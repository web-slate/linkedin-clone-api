package com.linkedin.network.entity;

import javax.persistence.*;

import lombok.*;

@Table(name = "t_login")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginUser {
	@Id
	@Column(name = "user_id")
	private String userId;
	private String password;

}
