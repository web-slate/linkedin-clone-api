package com.linkedin.network.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "t_skills")
@Data
public class Skills {
	@Column(name = "user_id")
	public String userId;
	@Column(name = "skill")
	public String skill;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;
}
