package com.student.management.service;

 

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
 
@Service
@Transactional
public class StudentService {
	@Autowired
    private StudentRepository repo;
     
    public List<Student> listAll() {
       
        List<Student> books = new ArrayList<Student>();  
        repo.findAll().forEach(books1 -> books.add(books1));  
        return books;  
    }
     
    public void save(Student student) {
        repo.save(student);
    }
     
    public Student get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
	
	
 
   
}