package com.test.repository;



import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Student;
@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable>{

  @Query(value="select * from student" ,nativeQuery = true)
  List<Student> displayStudent2();
  
  @Query(value="select * from student s where age=?1" ,nativeQuery = true)
  Optional<Student> displayStudentByRollNo2(int age);
  
  @Modifying
 //@Query(value ="delete from student s where s.age=?1",nativeQuery = true)
 @Query(value="delete from student s where s.age =:age",nativeQuery = true)
   int deleteStudent2(int age);
  
  
  @Query(value="select * from student s where age=?1" ,nativeQuery = true)
  List<Student> findSameAge(int age);
}
