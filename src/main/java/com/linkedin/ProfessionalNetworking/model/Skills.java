package com.linkedin.ProfessionalNetworking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
