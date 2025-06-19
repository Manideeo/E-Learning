package com.example.ecomm.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecomm.dto.User;
import com.example.ecomm.repository.UserRepository;
@Repository
public class UserDao {
	
	
	@Autowired
	UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User login(String email,String password) {
		return repository.login(email,password);
	}
	
	public User findUserById(long userID) {
		Optional<User> userDb= repository.findById(userID);
		if(userDb.isPresent()) return userDb.get();
		return null;
	}
	
	

}
