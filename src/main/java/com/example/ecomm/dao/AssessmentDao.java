package com.example.ecomm.dao;

import java.util.Optional;import java.util.Spliterators.AbstractDoubleSpliterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecomm.dto.Assessment;
import com.example.ecomm.repository.AssessmentRepository;

@Repository
public class AssessmentDao {
	@Autowired
	AssessmentRepository assessmentRepository;
	
	public Assessment saveAssessment(Assessment assessment) {
		return assessmentRepository.save(assessment);
	}
	
	public Assessment findAssessById(long id) {
		Optional<Assessment> adb= assessmentRepository.findById(id);
		
		if(adb.isPresent()) {
			return adb.get();
		}
		else return null;
	
	}
	

}
