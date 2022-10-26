package com.student.management.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.student.management.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>, JpaRepository<Student,Integer> {
	 
}