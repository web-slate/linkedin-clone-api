package com.linkedin.network.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_experience")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;

    @Column(name="user_id")
    public String userId;

    @Column(name="title")
    public String title;

    @Column(name="employment_type")
    public String employmentType;

    @Column(name="company_name")
    public String companyName;

    @Column(name="location")
    public String location;

    @Column(name="active")
    public Boolean currentCompany;

    @Column(name="start_date")
    public String startDate;

    @Column(name="end_date")
    public String endDate;

    @Column(name= "description")
    public String description;
}
