package com.ily.springMvcProject.services;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class TestServices implements ApplicationContextAware{
		@Value("${name}")
	private String name ;
	
		@Value("test")
	private String projectName;
	
	private ApplicationContext context;
	


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		context = applicationContext;
		
		System.out.println(context.getMessage("label_project_name", null, Locale.getDefault()));
	}
}
