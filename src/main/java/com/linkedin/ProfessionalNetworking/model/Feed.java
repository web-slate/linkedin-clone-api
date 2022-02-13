package com.linkedin.ProfessionalNetworking.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="t_user_feed")
@Data
public class Feed {
    @Id
    @Column(name="feed_id")
    private String feedId;

    @Column(name="user_id")
    private String userId;

    @Column(name="legalName")
    public String legalName;

    @Column(name="occupation")
    public String occupation;

    @Column(name="companyName")
    public String companyName;

    @Column(name="feedMsg")
    public String feedMsg;

    @Column(name="totalLike")
    public String totalLikes;

    @Column(name="totalComment")
    public String totalComments;

    @Column(name="comment")
    public String comment ;

    @Column(name="connectionType")
    public String connectionType;
}
