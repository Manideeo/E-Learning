package com.example.ecomm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    private String name;
    private String role; // Student or Instructor
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_courses",
        joinColumns = @JoinColumn(name = "userID"),
        inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    @JsonIgnore
    private List<Course> courses;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Submission> submissions;

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }

    public List<Submission> getSubmissions() { return submissions; }
    public void setSubmissions(List<Submission> submissions) { this.submissions = submissions; }
}
