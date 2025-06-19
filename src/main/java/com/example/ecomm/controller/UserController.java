package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Enrollment;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.service.UserService;
import com.example.ecomm.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user) {
		return service.login(user.getEmail(), user.getPassword());
	}

	@PostMapping("/addc2s/{uid}/{cid}")
	public ResponseEntity<ResponseStructure<User>> addCourseToStudent(@PathVariable long uid, @PathVariable long cid)
			throws IdNotFoundException {

		return service.addCourseToStudent(uid, cid);

	}

	@DeleteMapping("deletecFromU/{uid}/{cid}")
	public ResponseEntity<ResponseStructure<Course>> deletecFromU(@PathVariable long uid, @PathVariable long cid)
			throws IdNotFoundException {
		return service.deletecFromU(uid, cid);
	}

	@GetMapping("/getEnrolls/{uid}")
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrolls(@PathVariable int uid)
			throws IdNotFoundException {
		return service.getEnrolls(uid);
	}

	@GetMapping("/getSubmissions/{uid}")
	public ResponseEntity<ResponseStructure<List<Submission>>> getSubmissions(@PathVariable int uid)
			throws IdNotFoundException {
		return service.getSubmissions(uid);
	}

}
