package com.akog02.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userInRole")
public class UserInRole {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private Long userId;
	@ManyToOne(fetch =FetchType.EAGER,optional=false)
    @JoinColumn(name="userInRole_userId")
    private User user;
	
	private Long roleId;
	@ManyToOne(fetch =FetchType.EAGER,optional=false)
    @JoinColumn(name="userInRole_roleId")
    private Role role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
