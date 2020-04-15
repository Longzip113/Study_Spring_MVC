package com.longnguyen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class RoleEntity {
	
	@Id //(định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id tự động tăng
	private Long id;  
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT") // nếu hoa thì tự động chuyển thành thường và thêm _
	private String shortDescripTion;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescripTion() {
		return shortDescripTion;
	}

	public void setShortDescripTion(String shortDescripTion) {
		this.shortDescripTion = shortDescripTion;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
