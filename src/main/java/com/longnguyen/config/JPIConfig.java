package com.longnguyen.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.longnguyen.repository"}) // Khai báo để sử dung JPArepository
@EnableTransactionManagement // định nghĩa Entity transaction 
public class JPIConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource()); // Hàm getConnection() bên jdbc 
		em.setPersistenceUnitName("persistence-data"); //chất súc tác giữa entity và database (tạo peristence.xml trong META-INF)
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties()); // thực thi câu lệnh cơ sở dữ liệu
		return em;
	}
	
	
	//Tính năng quản lý transaction entity 
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	//đi cùng với transaction
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	//Nơi load database
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/SpringMVC");
		dataSource.setUsername("root");
		dataSource.setPassword("long250599");
		return dataSource;
	}
	
	 Properties additionalProperties(){
		 Properties properties = new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // mới đầu tạo table thì dùng drop 
			//properties.setProperty("hibernate.hbm2ddl.auto", "none"); // tạo table sau thì dùng none
			return properties;
	 }
}
