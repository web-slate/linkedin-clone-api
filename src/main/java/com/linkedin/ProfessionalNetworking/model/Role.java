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
@Table(name="t_role")
@Data
public class Role {
    @Id
    @Column(name="role_id")
    private String roleId;
    @Column(name="rollname")
    private String rollName;
}
