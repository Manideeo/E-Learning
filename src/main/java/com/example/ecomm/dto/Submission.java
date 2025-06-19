package com.example.ecomm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long submissionID;

	private int score;

	@ManyToOne
	@JoinColumn(name = "assessmentID")
	@JsonIgnore
	private Assessment assessment;

	@ManyToOne
	@JoinColumn(name = "studentID")
	private User student;

	// Getters and Setters
	public Long getSubmissionID() {
		return submissionID;
	}

	public void setSubmissionID(Long submissionID) {
		this.submissionID = submissionID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}
}
