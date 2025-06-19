package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.User;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.service.CourseService;
import com.example.ecomm.util.ResponseStructure;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping("/saveCourse")
	public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);

	}

	@GetMapping("/addi2c/{cid}/{uid}")
	public ResponseEntity<ResponseStructure<Course>> addI2c(@PathVariable long cid, @PathVariable long uid)
			throws IdNotFoundException {
		return courseService.addI2c(cid, uid);
	}

	@PostMapping("/addA2c/{cid}/{aid}")
	public ResponseEntity<ResponseStructure<Course>> addA2c(@PathVariable long cid, @PathVariable long aid)
			throws IdNotFoundException {
		return courseService.addA2C(cid, aid);

	}

}
