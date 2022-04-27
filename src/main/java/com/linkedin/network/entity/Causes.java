package com.linkedin.ProfessionalNetworking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_experience")
@Data
public class Causes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long causeId;

    @Column(name="user_id")
    public String userId;

    @Column(name="cause")
    public String cause;
}
