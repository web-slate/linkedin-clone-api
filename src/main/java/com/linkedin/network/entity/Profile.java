package com.linkedin.network.entity;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user_profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "additional_name")
	private String additionalName;

	@Column(name = "user_id")
	private String userId;

	private Date birthday;

}
