package com.akog02.common;
import java.util.Date;
import javax.persistence.Version;

public class BaseEntity {
	
private boolean Active;
@Version
private Integer Version;

private Date CreatedDate;
private Integer CreatedUserID;

private Date UpdatedDate;
private Integer UpdatedUserID;
public BaseEntity() {
	
}
public BaseEntity(boolean active, Integer version, Date createdDate, Integer createdUserID, Date updatedDate,
		Integer updatedUserID) {
	Active = active;
	Version = version;
	CreatedDate = createdDate;
	CreatedUserID = createdUserID;
	UpdatedDate = updatedDate;
	UpdatedUserID = updatedUserID;
}
public boolean isActive() {
	return Active;
}
public void setActive(boolean active) {
	Active = active;
}
public Integer getVersion() {
	return Version;
}
public void setVersion(Integer version) {
	Version = version;
}
public Date getCreatedDate() {
	return CreatedDate;
}
public void setCreatedDate(Date createdDate) {
	CreatedDate = createdDate;
}
public Integer getCreatedUserID() {
	return CreatedUserID;
}
public void setCreatedUserID(Integer createdUserID) {
	CreatedUserID = createdUserID;
}
public Date getUpdatedDate() {
	return UpdatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	UpdatedDate = updatedDate;
}
public Integer getUpdatedUserID() {
	return UpdatedUserID;
}
public void setUpdatedUserID(Integer updatedUserID) {
	UpdatedUserID = updatedUserID;
}
}
