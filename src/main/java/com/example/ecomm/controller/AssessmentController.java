package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Assessment;
import com.example.ecomm.service.AssessmentService;
import com.example.ecomm.util.ResponseStructure;

@RestController
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	@PostMapping("saveAssess")
	public ResponseEntity<ResponseStructure<Assessment>> saveAssessment(@RequestBody Assessment assessment) {
		return assessmentService.save(assessment);
	}
}
