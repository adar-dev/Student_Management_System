package com.student.management.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.management.model.Student;

public class StudentRepositoryImpl {

	@Autowired
	private StudentRepository repo;
	
	//find the student with given id in the database
	public String saveStudent(Student s) {
		Optional<Student> insertStudent = repo.findById(s.getId());
		if (insertStudent.isPresent()) {
			return "false";
		} else {
			repo.save(s);
			return "true";
		}
	}
	
	//find and allow the user to edit the details of the student by id and then save it 
	public String editStudent(Student s) {
		Optional<Student> insertStudent = repo.findById(s.getId());
		if (insertStudent.isPresent()) {
			repo.save(s);
			return "true";
		} else {
			
			return "false";
		}
	}
	
	public String editStudents(Student s) {
		repo.save(s);
		return "true";
	}
	
	//creates a arraylist of all the students present in the database and returns the list
	public ArrayList<Student> allStudents() {
		ArrayList<Student> ListAll = (ArrayList<Student>) repo.findAll();
		return ListAll;
	}

	//creates a arraylist of the names of the students and returns it
	public ArrayList<Student> findByName(String name) {

		ArrayList<Student> ListAll = (ArrayList<Student>) repo.findAll();
		ArrayList<Student> nameList = new ArrayList<Student>();
		for (Student s : ListAll) {
			if (s.getName().equalsIgnoreCase(name))
				nameList.add(s);
		}
		return nameList;
	}
	
	//finds the student by id 
	public Student findById(Integer id) {
		return repo.findById(id).get();
	}
	
	//deletes the student
	public void deleteStudentById(Integer id) {
		repo.deleteById(id);
	}
}