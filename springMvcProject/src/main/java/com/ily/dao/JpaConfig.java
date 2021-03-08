package com.ily.dao;

import java.util.Properties;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.ws.WebEndpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration

public class JpaConfig {
	
	@Value("${driver}")String driverClassName;
	@Value("${url}") String url;
	@Value("${user}")String user;
	@Value("${password}")String password;

	@Bean
	 JpaTransactionManager jpaTransactionManager() {
		
		return new JpaTransactionManager();
	}
	
	@Bean
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean =
				new LocalContainerEntityManagerFactoryBean();
				factoryBean.setPackagesToScan("com.ily.entity");
				factoryBean.setDataSource(dataSource());
				factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
				factoryBean.setJpaProperties(jpaProperties());
				factoryBean.afterPropertiesSet();
				return factoryBean.getNativeEntityManagerFactory();
	}
	@Bean
	EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Bean
	public Properties jpaProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect",
		"org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProp.put("hibernate.show_sql", true);
		return hibernateProp;
	}
	
	@Bean 
	public javax.sql.DataSource dataSource() {	
		DriverManagerDataSource mng = new DriverManagerDataSource();
		mng.setDriverClassName(driverClassName);
		mng.setUrl(url);
		mng.setUsername(user);
		mng.setPassword(password);
		return mng;
	}
	
}
