package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.EnrollmentDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Enrollment;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.repository.EnrollementRepository;
import com.example.ecomm.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	@Autowired
	CourseDao courseDao;

	@Autowired
	EnrollmentDao enrollmentDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		
		structure.setMsg("account created successfully!!");
		structure.setData(dao.saveUser(user));
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> login(String email, String password) {
		User user = dao.login(email, password);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		if (user != null) {

			structure.setMsg("login successful");
			structure.setData(user);
			structure.setStatusCode(HttpStatus.OK.value());

		} else {

			structure.setMsg("Invalid credentials");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.UNAUTHORIZED.value());

		}
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> addCourseToStudent(long userId, long cid)
			throws IdNotFoundException {

		User userdb = dao.findUserById(userId);
		Course coursedb = courseDao.findCourseById(cid);

		ResponseStructure<User> structure = new ResponseStructure<User>();

		if (userdb != null && coursedb != null) {

			List<Enrollment> enrls = userdb.getEnrollments();
			Enrollment enrollment = new Enrollment();
			enrollment.setCourse(coursedb);
			enrollment.setStudent(userdb);
			enrollment.setProgress(0);
			enrls.add(enrollment);

			structure.setMsg("course added successfully!!");
			structure.setData(dao.saveUser(userdb));
			structure.setStatusCode(HttpStatus.OK.value());

		} else {
			throw new IdNotFoundException("id not found");
		}

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Course>> deletecFromU(long uid, long cid) throws IdNotFoundException {
		User userdb = dao.findUserById(uid);
		Course coursedb = courseDao.findCourseById(cid);

		ResponseStructure<Course> structure = new ResponseStructure<Course>();
		if (userdb != null && coursedb != null) {
			structure.setMsg("deleted successfully!");
			structure.setData(coursedb);
			structure.setStatusCode(HttpStatus.OK.value());

			List<Course> courses = userdb.getCourses();
			courses.remove(coursedb);
		} else {
			throw new IdNotFoundException("id not found");
		}
		return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrolls(int uid) throws IdNotFoundException {

		ResponseStructure<List<Enrollment>> structure = new ResponseStructure<List<Enrollment>>();

		User user = dao.findUserById(uid);
		if (user != null) {
			structure.setMsg("the list of enrolls");
			structure.setData(user.getEnrollments());
			structure.setStatusCode(HttpStatus.OK.value());
		} else {
			throw new IdNotFoundException("no id");
		}

		return new ResponseEntity<ResponseStructure<List<Enrollment>>>(structure, HttpStatus.OK);
	}

	@GetMapping("/getSubmissions/{sid}")
	public ResponseEntity<ResponseStructure<List<Submission>>> getSubmissions(@PathVariable int uid)
			throws IdNotFoundException {
		User user = dao.findUserById(uid);
		ResponseStructure<List<Submission>> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setMsg("the list of submissions");
			structure.setData(user.getSubmissions());
			structure.setStatusCode(HttpStatus.OK.value());

		} else {
			throw new IdNotFoundException("id not found");
		}
		return new ResponseEntity<ResponseStructure<List<Submission>>>(structure, HttpStatus.OK);
	}

}
