package com.example.ecomm.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecomm.dto.Enrollment;
import com.example.ecomm.repository.EnrollementRepository;

@Repository
public class EnrollmentDao {
	
	@Autowired
	EnrollementRepository enrollementRepository;
	
	public void enroll(Enrollment enrollment) {
		
		enrollementRepository.save(enrollment);
		
	}
	
	public Enrollment findById(long eid) {
		Optional<Enrollment> optional=enrollementRepository.findById(eid);
		if(optional.isPresent()) return optional.get();
		return null;
	}

}
