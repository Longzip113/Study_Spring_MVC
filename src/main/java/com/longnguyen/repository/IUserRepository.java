package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longnguyen.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findOneByUserNameAndStatus(String name, Integer status);
}
