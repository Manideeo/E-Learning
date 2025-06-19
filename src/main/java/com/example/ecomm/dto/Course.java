package com.example.ecomm.dto;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    private String title;
    private String description;
    private String contentURL;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Assessment> assessments;

    // Getters and Setters
    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        assessments.forEach(assessment -> assessment.setCourse(this)); // Ensure mapping
        this.assessments = assessments;
    }
}
