package com.studentmanegmentsystem.servicei;

import java.util.List;

import com.studentmanegmentsystem.model.Student;

public interface ServiceI {

	public List<Student> getAllStudent();
	public List<Student> addStudent(Student s);
	
	public List<Student> searchStudentByBatch(String batchNumber);
}
