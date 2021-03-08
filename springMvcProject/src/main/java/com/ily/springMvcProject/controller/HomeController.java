package com.ily.springMvcProject.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ily.springMvcProject.services.TestServices;
import com.ily.springMvcProject.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private TestServices testServices;
	@Autowired
	private UserService userServices;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		System.out.println(testServices.getName());
		System.out.println(testServices.getProjectName());
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i < 4; i++)
			userServices.ajouterUser("user"+i);
		System.out.println(userServices.getUsers());
		map.put("user", "user");
		return new ModelAndView("home");
	}

	
}
