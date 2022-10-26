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
	
	//To get the list of all the students present in the database.
	@GetMapping("/students")
	public List<Student> list() {
	    return service.getAllStudents();
	}
	
	
	/*To get the division/status of student of a specified id.
	 * If the avg score is above 60 then --> 1st div
	 *  If the avg score is between 40 and 60 then -->2nd div
	 *  If the avg score is below 40 then --> Failed
	 * */
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
	
	//To get the student details based on given id.
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
	    try {
	    	Student student = service.getStudentById(id);
	        return new ResponseEntity<Student>(student, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	        
	    }      
	}
	
	
	//This method adds the new student details to the database table.
	@PostMapping("/students")
	 @Consumes({"application/json", "application/x-www-form-urlencoded"})
	
	
	public ResponseEntity<Object> add(@RequestBody Student student) {
		System.out.println(student);
	    service.insertStudent(student);
	    return new ResponseEntity<>("posted", HttpStatus.OK);
	}
	
	//This method is used to update the data of the existing student.
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
	
	
	//This method deletes the student details based on id.
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
	    service.deleteStudent(id);
	}


}
