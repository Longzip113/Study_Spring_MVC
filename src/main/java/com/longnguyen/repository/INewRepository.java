package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longnguyen.entity.NewEntity;

public interface INewRepository extends JpaRepository<NewEntity, Long>{
	
}
