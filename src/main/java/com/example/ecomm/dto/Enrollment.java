package com.example.ecomm.dto;

import jakarta.persistence.*;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentID;

	private int progress;

	@ManyToOne
	@JoinColumn(name = "studentID")
	private User student;

	@ManyToOne
	@JoinColumn(name = "courseID")
	private Course course;

	public Long getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(Long enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
