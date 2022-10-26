package com.student.management.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.exception.StudentNotFoundException;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;


@RestController

@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("api")

public class StudentController {
	@Autowired
    private StudentService service;
	@Autowired
    StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> list() {
	    return service.getAllStudents();
	}
	@GetMapping("/students/status/{id}")
	public ResponseEntity<String> getStatus(@PathVariable Integer id) {
		
		try {
	    	Student student = service.getStudentById(id);
	    	Float avg = (student.getPhysics()+student.getChemistry()+student.getBiology())/3;
	    	if(avg>=60) {
	    		return new ResponseEntity<String>("1st Div", HttpStatus.OK);
	    		
	    	}
	    	else if(avg>=40) {
	    		return new ResponseEntity<String>("2nd Div", HttpStatus.OK);
	    		
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
	 @Consumes({"application/json", "application/x-www-form-urlencoded"})
	
	
	public ResponseEntity<Object> add(@RequestBody Student student) {
		System.out.println(student);
	    service.insertStudent(student);
	    return new ResponseEntity<>("posted", HttpStatus.OK);
	}
	
	@PutMapping("/students/{id}" )
	@Consumes({"application/json", "application/x-www-form-urlencoded"})
	
	
	public String update( @RequestBody Student student) {
	    try {
	    	System.out.println(student);
	        return service.editStudent(student);

	    } catch (NoSuchElementException e) {
	        throw new StudentNotFoundException("Student not found");
	    }      
	}

	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
	    service.deleteStudent(id);
	}


}
