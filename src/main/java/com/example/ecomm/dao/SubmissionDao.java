package com.example.ecomm.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecomm.dto.Submission;
import com.example.ecomm.repository.SubmissionRepository;

@Repository
public class SubmissionDao {
	
	@Autowired
	SubmissionRepository repository;
	
	public Submission saveSubmission(Submission submission) {
		return repository.save(submission);
	}
	
	public Submission findById(long sid) {
		Optional<Submission> optional=repository.findById(sid);
		if(optional.isPresent()) return optional.get();
		return null;
				
	}
}
