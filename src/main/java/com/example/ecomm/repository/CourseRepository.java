package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
