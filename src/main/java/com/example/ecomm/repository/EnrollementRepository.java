package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.dto.Enrollment;

public interface EnrollementRepository extends JpaRepository<Enrollment, Long> {

}
