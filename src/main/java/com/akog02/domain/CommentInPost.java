package com.akog02.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.akog02.common.BaseEntity;
@Entity
@Table(name="commentInpost")
public class CommentInPost extends BaseEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private Integer PostId;
	@ManyToOne(fetch =FetchType.EAGER,optional=false)
    @JoinColumn(name="commentInpost_postid")
    private Post post;
	
	/*private Long UserId;
	@ManyToOne(fetch =FetchType.EAGER,optional=false)
    @JoinColumn(name="commentInpost_userId")
    private User user;*/
	
	private String UserName;
	private String Email;
	private String WebSite;
	
	private String Comment;
		
	public CommentInPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentInPost(boolean active, Integer version, Date createdDate, Integer createdUserID, Date updatedDate,
			Integer updatedUserID,Integer _postid,String username,String email,String website,String comment) {
		super(active, version, createdDate, createdUserID, updatedDate, updatedUserID);
		// TODO Auto-generated constructor stub
		this.PostId=_postid;this.UserName=username;this.Email=email;this.WebSite=website;this.Comment=comment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPostId() {
		return PostId;
	}
	public void setPostId(Integer postId) {
		PostId = postId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	/*public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getWebSite() {
		return WebSite;
	}
	public void setWebSite(String webSite) {
		WebSite = webSite;
	}
	
}
