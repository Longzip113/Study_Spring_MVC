package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longnguyen.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
	
}
