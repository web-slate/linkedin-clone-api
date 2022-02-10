package com.linkedin.ProfessionalNetworking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_user_role")
@Data
public class UserRole {
    @Column(name="user_id")
    private String userId;
    @Column(name="role_id")
    private String roleId;
}
