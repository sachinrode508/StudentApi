package com.test.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.controller.StudentController;
import com.test.model.Student;
import com.test.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
 
	@Autowired
	private StudentRepository studentRepository; 
	
	public static final Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	
	@Override
	public Student saveStudent(Student student) {
		 return studentRepository.save(student);
	
	}

	@Override
	public List<Student> displayStudent() {
		logger.info("inside the display student in service");
		return studentRepository.findAll();
		
	}

	@Override
	public void deleteStudent(int rollNo) {
		studentRepository.deleteById(rollNo);
	}

	@Override
	public Optional<Student> displayStudentByRollNo(int rollNo) {
		 return studentRepository.findById(rollNo);			
	}

	@Override
	public List<Student> displayStudent2() {
		return studentRepository.displayStudent2();
		
	}

	@Override
	public Optional<Student> displayStudentByRollNo2(int age) {
		 return studentRepository.displayStudentByRollNo2(age);			
	}

	@Override
	public List<Student> deleteStudent2(int age) {
		List<Student> stu = studentRepository.findSameAge(age);
		studentRepository.deleteStudent2(age);
		return stu;
		
	}

	}