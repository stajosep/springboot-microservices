package com.oracle.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	public UserDaoService() {
		
	}
	
	private static List<User> users = new ArrayList<>();

	private static int count = 3;
	
	static {
		users.add(new User(1,"Staphy", new Date()));
		users.add(new User(2,"Jerin", new Date()));
		users.add(new User(1,"Joseph", new Date()));
	
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
