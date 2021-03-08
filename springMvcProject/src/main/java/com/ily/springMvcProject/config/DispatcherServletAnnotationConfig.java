package com.ily.springMvcProject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import com.ily.springMvcProject.services.ServicesConfig;




public class DispatcherServletAnnotationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		Class<?>[] annotationConfig = {ServicesConfig.class};
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
	
	@Bean
	static InternalResourceViewResolver internalResourceViewResolver() {
		
	  	return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}
	
	@Bean
	static BeanNameViewResolver beanNameViewResolver(){
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}
}
