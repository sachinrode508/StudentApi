package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	//save student data using jpaRepository
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student stu = studentService.saveStudent(student);
		return ResponseEntity.ok().body(stu);
	}

	//display all student data using jpaRepository
	@GetMapping("/displayStudent")
	public List<Student> displayStudent() {
		List<Student> student = studentService.displayStudent();
		return student;
	}
	
	//display all student data using native query
	@GetMapping("/displayStudent2")
	public List<Student> displayStudent2() {
		List<Student> student = studentService.displayStudent2();
		return student;
	}
	
	//display student data by id jpaRepository
	@GetMapping("/displayStudentByRollNo/{rollNo}")
	public ResponseEntity<Optional<Student>> displayStudentByRollNo(@PathVariable int rollNo) {
		Optional<Student> student = studentService.displayStudentByRollNo(rollNo);
		return ResponseEntity.ok().body(student);
	}
	
	//display student data by age using native query
	@GetMapping("/displayStudentByRollNo2/{age}")
	public ResponseEntity<Optional<Student>> displayStudentByRollNo2(@PathVariable int age) {
		Optional<Student> student = studentService.displayStudentByRollNo2(age);
		return ResponseEntity.ok().body(student);
	}

	//delete student data by rollNo using jpaRepository
	@DeleteMapping("/deleteStudent/{rollNo}")
	public void deleteStudent(@PathVariable int rollNo) {
		studentService.deleteStudent(rollNo);
	}
	
	//delete student data by age using native query
	@DeleteMapping("/deleteStudent2/{age}")
	public ResponseEntity<List<Student>> deleteStudent2(@PathVariable int age) {
		 List<Student> stu =studentService.deleteStudent2(age);
		 return ResponseEntity.ok().body(stu);
	}

	
}
