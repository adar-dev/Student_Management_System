package com.student.management.service;

 

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.exception.StudentNotFoundException;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.repository.StudentRepositoryImpl;
 
@Service
@Transactional
public class StudentService {
	
	@Autowired
	
	private StudentRepositoryImpl repoImpl;
	
	//inserts the new student data and saves it
	public String insertStudent(Student s) {

		return repoImpl.saveStudent(s);
	}
	
	//updates the student data
	public String editStudent(Student s) {

		return repoImpl.editStudent(s);
	}
	
	/*displays the list of the students 
	 * try catch is used to check whether the list is empty or not.
	 */
	public ArrayList<Student> getAllStudents() {

		ArrayList<Student> ListAll = new ArrayList<Student>();
		try {

			ListAll = repoImpl.allStudents();
			if (ListAll.isEmpty()) {
				throw new StudentNotFoundException("Student Not Found In Database");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ListAll;
	}
	public ArrayList<Student> getStudentByName(String name) {
		ArrayList<Student> nameList = new ArrayList<Student>();
		try {
			nameList = repoImpl.findByName(name);
			if (nameList.isEmpty()) {
				throw new StudentNotFoundException("Student Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nameList;
	}
	
	//display the details for the student with given id
	public Student getStudentById(Integer id) {
		
		Student s = null;
		try {
			s = repoImpl.findById(id);
			if(s == null) {
				throw new StudentNotFoundException("Student with this Id Not Found");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	//deletes the student by id
	public void deleteStudent(Integer id) {
      repoImpl.deleteStudentById(id);
  }
	
	
//	@Autowired
//    private StudentRepository repo;
//     
//    public List<Student> listAll() {
//       
//        List<Student> books = new ArrayList<Student>();  
//        repo.findAll().forEach(books1 -> books.add(books1));  
//        return books;  
//    }
//     
//    public void save(Student student) {
//        repo.save(student);
//    }
//     
//    public Student get(Integer id) {
//        return repo.findById(id).get();
//    }
//     
//    public void delete(Integer id) {
//        repo.deleteById(id);
//    }
	
	
 
   
}