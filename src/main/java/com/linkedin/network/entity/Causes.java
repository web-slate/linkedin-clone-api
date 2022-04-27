package com.linkedin.network.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
