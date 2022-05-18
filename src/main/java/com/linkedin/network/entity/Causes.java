package com.linkedin.network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_causes")
@Data
public class Causes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cause_id")
    private Long causeId;

    @Column(name="user_id")
    public String userId;

    @Column(name="cause")
    public String cause;
}
