package com.linkedin.ProfessionalNetworking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_education")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    @Column(name="user_id")
    public String userId;

    @Column(name="language")
    public String language;

    @Column(name="proficiency")
    public String proficiency;
}
