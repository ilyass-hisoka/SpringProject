package com.ily.springMvcProject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ily.springMvcProject.services.TestServices;

@Controller
public class HomeController {

	@Autowired
	private TestServices testServices;
	
	
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		System.out.println(testServices.getName());
		System.out.println(testServices.getProjectName());
		
		return new ModelAndView("xlsView");
	}

	
}
