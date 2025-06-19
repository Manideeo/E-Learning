package com.example.ecomm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.SubmissionDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.util.ResponseStructure;

@Service
public class SubmissionService {

	@Autowired
	SubmissionDao submissionDao;

	@Autowired
	CourseDao courseDao;

	@Autowired
	UserDao userDao;

	@Autowired
	AssessmentDao assessmentDao;

	public ResponseEntity<ResponseStructure<Submission>> saveSubmission(Submission submission, long uid, long aid)
			throws IdNotFoundException {

		ResponseStructure<Submission> structure = new ResponseStructure<Submission>();

		User user = userDao.findUserById(uid);
		Assessment assessment = assessmentDao.findAssessById(aid);
		if (user != null && assessment != null) {

			submission.setStudent(user);
			submission.setAssessment(assessment);

			structure.setData(submissionDao.saveSubmission(submission));
			structure.setMsg("submission saved");
			structure.setStatusCode(HttpStatus.OK.value());

		} else {
			throw new IdNotFoundException("id not found");
		}
		return new ResponseEntity<ResponseStructure<Submission>>(structure, HttpStatus.OK);
	}

	public Submission findById(long sid) {
		return submissionDao.findById(sid);

	}
}
