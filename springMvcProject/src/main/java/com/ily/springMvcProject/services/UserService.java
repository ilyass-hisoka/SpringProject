package com.ily.springMvcProject.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ily.dao.UserDao;
import com.ily.entity.User;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserService {
	@Value("ilyass")
	private String name;
	
	@Autowired
	UserDao userDao;
	
	
	@Transactional
	public void ajouterUser(String name) {
		User user1 = new User();
		user1.setName(name);
		userDao.ajouterUser(user1);
	}
	
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
}
