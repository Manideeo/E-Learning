package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	public User login(@Param("email") String email, @Param("password") String password);


}
