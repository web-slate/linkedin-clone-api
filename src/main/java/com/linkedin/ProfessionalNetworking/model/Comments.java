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
@Table(name="comments")
@Data
public class Comments {
    @Id
    @Column(name="post_id")
    private String postId;
    @Column(name="comment_id")
    private String commentId;
    @Column(name="comments")
    private String comments;
}
