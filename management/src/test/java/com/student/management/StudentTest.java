package com.student.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentTest {

	@Autowired
	StudentRepository repo;
	
	@Test
	@Order(1)
	public void testCreate () {
	    Student s = new Student();
		s.setId(2);
		s.setName("Raj");
		s.setDateOfAdmission("11/3/2004");
		s.setPhysics(20);
		s.setChemistry(60);
		s.setBiology(58);
		
		
		repo.save(s);
		assertNotNull(repo.findById(2).get());
	}
		
	@Test
	@Order(2)
	public void testReadAll () {
		List list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testRead () {
		Student s = repo.findById(2).get();
		assertEquals("Raj", s.getName());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		Student s = repo.findById(2).get();
		s.setPhysics(100);
		repo.save(s);
		assertNotEquals(70, repo.findById(2).get().getPhysics());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		repo.deleteById(2);
		assertThat(repo.existsById(2)).isFalse();
	}
}