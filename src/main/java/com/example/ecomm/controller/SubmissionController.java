package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Submission;
import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.service.SubmissionService;
import com.example.ecomm.util.ResponseStructure;

@RestController
public class SubmissionController {

	@Autowired
	SubmissionService service;

	@PostMapping("/submit/{uid}/{aid}")
	public ResponseEntity<ResponseStructure<Submission>> submit(@RequestBody Submission submission,
			@PathVariable long uid, @PathVariable long aid) throws IdNotFoundException {

		return service.saveSubmission(submission, uid, aid);

	}

}
