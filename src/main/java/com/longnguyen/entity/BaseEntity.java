package com.longnguyen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass //Định nghĩa Entity cha 
@EntityListeners(AuditingEntityListener.class) // định nghĩa cho các by và date tự động
public abstract class BaseEntity {
	
	@Id //(định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id tự động tăng
	private Long id;  

	@Column(name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column(name = "createdBy")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modifiedBy")
	@LastModifiedBy
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}

	
}
