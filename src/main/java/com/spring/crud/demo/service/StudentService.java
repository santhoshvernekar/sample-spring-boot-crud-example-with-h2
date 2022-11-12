package com.spring.crud.demo.service;


import com.spring.crud.demo.model.Student;

import java.util.List;

public interface StudentService {
	
	List<Student> getAll();

	List<Student> getStudentByFirstName(String firstName);

	Student getOneStudentByFirstName(String firstName);

	List<Student> getStudentByFirstNameLike(String firstName);

	Student getStudentById(int empId);
	
	Student getStudentByLastName(String lastName);

	List<Student> getStudentByMarksGreaterThan(int marks);
	
	List<Student> getStudentByCondition(Student student);

}
