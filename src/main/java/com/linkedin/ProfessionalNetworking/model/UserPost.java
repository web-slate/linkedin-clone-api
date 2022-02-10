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
@Table(name="t_user_post")
@Data
public class UserPost {
    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="post_id")
    private String postId;
    @Column(name="postmessage")
    private String postMessage;
    @Column(name="nooflikes")
    private String noofLikes;
}
