package com.example.ecomm.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.User;
import com.example.ecomm.repository.CourseRepository;
import com.example.ecomm.repository.UserRepository;

@Repository
public class CourseDao {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Course saveCourse(Course course) {
		
		return courseRepository.save(course);
	}
	public Course findCourseById(long cid) {
		Optional<Course> coursedb= courseRepository.findById(cid);
		if(!coursedb.isEmpty()) {
			return coursedb.get();
		}
		return null;
	}
	

}
