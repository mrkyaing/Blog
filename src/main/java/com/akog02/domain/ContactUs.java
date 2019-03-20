package com.akog02.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.akog02.common.BaseEntity;

@Entity
public class ContactUs extends BaseEntity{	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}


private String Name;
private String Message;
private String Phone;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}


}
