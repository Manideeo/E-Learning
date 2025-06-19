package com.example.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.util.ResponseStructure;

@Service
public class AssessmentService {
	
	@Autowired
	AssessmentDao assessmentDao;
	
	public ResponseEntity<ResponseStructure<Assessment>> save(Assessment assessment) {
		
		ResponseStructure<Assessment> structure=new ResponseStructure<Assessment>();
		structure.setMsg("assessment saved successfully!!");
		structure.setData(assessmentDao.saveAssessment(assessment));
		structure.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<Assessment>>(structure, HttpStatus.OK);
	}
}
