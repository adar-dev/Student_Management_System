package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	 
}