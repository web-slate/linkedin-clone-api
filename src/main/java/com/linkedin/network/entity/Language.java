package com.linkedin.network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_languages")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private Long languageId;

    @Column(name="user_id")
    public String userId;

    @Column(name="language")
    public String language;

    @Column(name="proficiency")
    public String proficiency;
}
