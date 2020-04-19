package com.longnguyen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration //Bật tính năng config 
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") //Bật tính năng Auditing tự đọng lấy by và date 
public class JpaAuditingConfig {
	@Bean
	public AuditorAware<String> auditorProvider(){
		return new AuditorAwareImpl();
	}
	
	public static class AuditorAwareImpl implements AuditorAware<String>{

		
		//Get() userName ra cho By cấu hình để lấy tên ra 
		@Override
		public String getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // phải thêm thư viện secutity trong pom.xml
			if(authentication == null) {
				return null;
			}
			return authentication.getName();
		}
	}
}
