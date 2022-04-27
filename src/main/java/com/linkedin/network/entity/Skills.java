package com.linkedin.network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_skills")
@Data
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(name="user_id")
    public String userId;

    @Column(name="skill")
    public String skill;
}
