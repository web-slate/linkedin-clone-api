package com.linkedin.network.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user_feed")
@Data
public class Feed {
	@Column(name = "legalname")
	public String legalName;
	@Column(name = "occupation")
	public String occupation;
	@Column(name = "companyname")
	public String companyName;
	@Column(name = "feedmsg")
	public String feedMsg;
	@Column(name = "totallike")
	public String totalLikes;
	@Column(name = "totalcomment")
	public String totalComments;
	@Column(name = "comment")
	public String comment;
	@Column(name = "connectiontype")
	public String connectionType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedId;
	@Column(name = "user_id")
	private String userId;
}
