package com.student.management.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.Student;
import com.student.management.service.StudentService;


@RestController

public class StudentController {
	@Autowired
    private StudentService service;
	
	@GetMapping("/students")
	public List<Student> list() {
	    return service.getAllStudents();
	}
	@GetMapping("/studentstatus/{id}")
	public ResponseEntity<String> getStatus(@PathVariable Integer id) {
		
		try {
	    	Student student = service.getStudentById(id);
	    	Float avg = (student.getPhysics()+student.getChemistry()+student.getBiology())/3;
	    	if(avg>=60) {
	    		return new ResponseEntity<String>("1st Division", HttpStatus.OK);
	    		
	    	}
	    	else if(avg>=40) {
	    		return new ResponseEntity<String>("2nd Division", HttpStatus.OK);
	    		
	    	}
	    	else {
	    		return new ResponseEntity<String>("Failed", HttpStatus.OK);
	    	}
	    	
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        
	    } 
	}
	
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
	    try {
	    	Student student = service.getStudentById(id);
	        return new ResponseEntity<Student>(student, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	        
	    }      
	}
	
	@PostMapping("/students")
	public void add(@RequestBody Student student) {
	    service.insertStudent(student);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
	    try {
	    	Student existStudent = service.getStudentById(id);
	        service.editStudent(student);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
	    service.deleteStudent(id);
	}


}
