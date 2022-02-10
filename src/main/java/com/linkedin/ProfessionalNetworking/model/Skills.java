package com.linkedin.ProfessionalNetworking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_skills")
@Data
public class Skills {
    @Id
    @Column(name="skill_id")
    private String skillId;
    @Column(name="skillname")
    private String skillName;
    @Column(name="skilltype")
    private String skillType;
}
