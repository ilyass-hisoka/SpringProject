package com.ily.springMvcProject.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ily.springMvcProject.services.ServicesConfig;
import com.ily.springMvcProject.services.TestServices;



public class DispatcherServletAnnotationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		Class<?>[] annotationConfig = {ServicesConfig.class,TestServices.class};
		return annotationConfig;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] annotationConfig = {AnnotationConfigWebApplication.class};
		return annotationConfig;
	}

	@Override
	protected String[] getServletMappings() {
		String[] servletMappin = {"/"};
		return servletMappin;
	}
	
	

}

@Configuration
@ComponentScan("com.ily.springMvcProject.services")
class AnnotationConfigRoot {
	
}

@Configuration
@ComponentScan("com.ily.springMvcProject.controller")
class AnnotationConfigWebApplication {
	
}
