package com.test.service;

import java.util.List;
import java.util.Optional;

import com.test.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> displayStudent();

	void deleteStudent(int rollNO);

	Optional<Student> displayStudentByRollNo(int rollNo);

	List<Student> displayStudent2();

	Optional<Student> displayStudentByRollNo2(int age);

	List<Student> deleteStudent2(int age);

}
