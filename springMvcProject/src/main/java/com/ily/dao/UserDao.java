package com.ily.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ily.entity.User;

@Repository
public class UserDao {

	@Autowired
	private EntityManager mng;
	
	public void ajouterUser(User user) {
		mng.persist(user);
	}

	public List<User> getUsers() {
		System.out.println(mng.find(User.class, 1).getName());
		Query q = mng.createNativeQuery("select user.name from User user");
		return q.getResultList();
		
	}
}
