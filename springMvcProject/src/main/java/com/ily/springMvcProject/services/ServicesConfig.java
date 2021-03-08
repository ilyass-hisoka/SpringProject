package com.ily.springMvcProject.services;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;


@Configuration
@ComponentScan(basePackages = {"com.ily.springMvcProject.services","com.ily.dao"})
public class ServicesConfig implements ApplicationContextAware {

	@Autowired
	ApplicationContext context;
	
	@Bean
	PropertySourcesPlaceholderConfigurer  getPlaceholder() {
		PropertySourcesPlaceholderConfigurer p = new  PropertySourcesPlaceholderConfigurer();
		Resource r = context.getResource("classpath:/config.properties");
		Resource r1 = context.getResource("classpath:/connection.properties");
		p.setLocations(r,r1);
		return p;
	}
	
	@Bean
	static ResourceBundleMessageSource  messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.addBasenames("info");
		
		System.out.println(rb.getMessage("label_project_name", null, Locale.getDefault()));
		return rb;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
		this.context = applicationContext;
		
	}
}
