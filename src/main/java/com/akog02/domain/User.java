package com.akog02.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.akog02.common.BaseEntity;

@Entity
@Table(name="user")
public class User extends BaseEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String UserName;
	
	private String Password;
    private String ConfirmPassword;
    
	private String Designation;
	
	private String Gender;
	
	private String Email;
	
	private boolean IsConfirm;
		
	public User() {
		
	}
	public User(String userName, String password, String designation, String gender, String email, boolean isConfirm) {
		super();
		UserName = userName;
		Password = password;
		Designation = designation;
		Gender = gender;
		Email = email;
		IsConfirm = isConfirm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isIsConfirm() {
		return IsConfirm;
	}

	public void setIsConfirm(boolean isConfirm) {
		IsConfirm = isConfirm;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPasswrod() {
		return Password;
	}

	public void setPasswrod(String passwrod) {
		Password = passwrod;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

}
