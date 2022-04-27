package com.linkedin.network.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="t_login")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginUser {
    @Id
    @Column(name="user_id")
    private String userId;
    private String password;

}
