package com.akog02.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.akog02.common.BaseEntity;
@Entity
@Table(name="role")
public class Role extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private int RoleLevel;
	private String RoleName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRoleLevel() {
		return RoleLevel;
	}
	public void setRoleLevel(int roleLevel) {
		RoleLevel = roleLevel;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
}
