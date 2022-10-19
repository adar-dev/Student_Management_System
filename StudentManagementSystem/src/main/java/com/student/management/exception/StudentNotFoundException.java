package com.student.management.exception;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
