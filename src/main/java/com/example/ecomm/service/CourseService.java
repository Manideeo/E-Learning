package com.example.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.User;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.util.ResponseStructure;

@Service
public class CourseService {
	@Autowired
	CourseDao courseDao;
	@Autowired
	UserDao userDao;

	@Autowired
	AssessmentDao assessmentDao;

	public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course) {

		ResponseStructure<Course> structure = new ResponseStructure<Course>();
		structure.setMsg("course added successfully...");
		structure.setData(courseDao.saveCourse(course));
		structure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Course>> addI2c(long cid, long uid) throws IdNotFoundException {

		User userdb = userDao.findUserById(uid);
		Course coursedb = courseDao.findCourseById(cid);

		ResponseStructure<Course> structure = new ResponseStructure<Course>();
		if (userdb != null && coursedb != null) {
			List<User> ul = new ArrayList<User>();
			ul.add(userdb);
			coursedb.setUsers(ul);

			structure.setMsg("Instructor added successfully!!");
			structure.setData(courseDao.saveCourse(coursedb));
			structure.setStatusCode(HttpStatus.OK.value());

		} else {
			throw new IdNotFoundException("id not found");
		}
		return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Course>> addA2C(long cid, long aid) throws IdNotFoundException {
		Assessment adb = assessmentDao.findAssessById(aid);
		Course coursedb = courseDao.findCourseById(cid);

		ResponseStructure<Course> structure = new ResponseStructure<Course>();
		if (adb != null && coursedb != null) {
			List<Assessment> al = coursedb.getAssessments();
			al.add(adb);
			coursedb.setAssessments(al);

			structure.setData(courseDao.saveCourse(coursedb));
			structure.setMsg("assessment added successfully!!");
			structure.setStatusCode(HttpStatus.OK.value());

		} else {
			throw new IdNotFoundException("id not found");
		}
		return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.ACCEPTED);

	}

}
