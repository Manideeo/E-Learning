package com.example.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.EnrollmentDao;
import com.example.ecomm.dto.Enrollment;

@Service
public class EnrollmentService {
	
	@Autowired
	EnrollmentDao enrollmentDao;
	
	public void save(Enrollment enrollment) {
		enrollmentDao.enroll(enrollment);
	}
	
	public Enrollment findById(long eid) {
		return enrollmentDao.findById(eid);
	}
	
	
}
