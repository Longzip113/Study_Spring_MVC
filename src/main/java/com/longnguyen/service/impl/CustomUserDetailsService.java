package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.longnguyen.constant.SystemConstant;
import com.longnguyen.dto.MyUser;
import com.longnguyen.entity.RoleEntity;
import com.longnguyen.entity.UserEntity;
import com.longnguyen.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity roles : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(roles.getCode()));
		}
		//put thông tin vào security duy trì thông tin khi user login hệ thống
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassWord(),
				true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
