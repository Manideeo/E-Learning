package com.example.ecomm.dto;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assessmentID;

    private String type; // Quiz or Assignment
    private int maxScore;

    @ManyToOne
    @JoinColumn(name = "courseID")
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submission> submissions;

    // Getters and Setters
    public Long getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Long assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        submissions.forEach(submission -> submission.setAssessment(this)); // Ensure mapping
        this.submissions = submissions;
    }
}
