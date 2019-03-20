package com.akog02.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.akog02.common.BaseEntity;

@Entity
public class Category extends BaseEntity{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer id;
public String Code;
public String Description;
public Category() {
	
}
public Category(boolean active, Integer version, Date createdDate, Integer createdUserID, Date updatedDate,
		Integer updatedUserID,String code,String description) {
	super(active, version, createdDate, createdUserID, updatedDate, updatedUserID);
	this.Code=code;this.Description=description;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
}
