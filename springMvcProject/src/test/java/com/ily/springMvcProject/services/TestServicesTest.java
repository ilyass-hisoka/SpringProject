package com.ily.springMvcProject.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class})
public class TestServicesTest {

	@Autowired
	UserService user;
	
	@Test
	public void testGetName() {
		assertNotNull(user);
		assertArrayEquals("ilyass".toCharArray(), user.getName().toCharArray());
	}

}
