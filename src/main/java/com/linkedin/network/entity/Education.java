package com.linkedin.network.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    @Column(name="user_id")
    public String userId;

    @Column(name="school")
    public String school;

    @Column(name="degree")
    public String degree;

    @Column(name="field_of_study")
    public String fieldOfStudy;

    @Column(name="start_month")
    public String startMonth;

    @Column(name="start_year")
    public String startYear;

    @Column(name="end_month")
    public String endMonth;

    @Column(name="end_year")
    public String endYear;
}
