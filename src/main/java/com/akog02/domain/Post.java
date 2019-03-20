package com.akog02.domain;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import com.akog02.common.BaseEntity;

@Entity
@Table(name="post")
public class Post  extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String Title;

    @Length(max = 255)
    private String BriefDescription;

    @Length(max = 50000000)//5,000,000
    private String Body;
    private String imageUrl;

    private Integer categoryId;
    @ManyToOne(fetch =FetchType.EAGER,optional=false)
    @JoinColumn(name="post_categoryid")
    private Category category;
      
	public Post() {
	}
	
	public Post(boolean active, Integer version, Date createdDate, Integer createdUserID, Date updatedDate,
			Integer updatedUserID,String title,String briefdesc,String body,String imageurl,Integer categoryid) {
		super(active, version, createdDate, createdUserID, updatedDate, updatedUserID);
		this.Title=title;this.BriefDescription=briefdesc;this.Body=body;this.imageUrl=imageurl;this.categoryId=categoryid;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getBriefDescription() {
		return BriefDescription;
	}
	public void setBriefDescription(String BriefDescription) {
		this.BriefDescription = BriefDescription;
	}  
}