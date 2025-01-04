package com.studentmanegmentsystem.servicei;

import java.util.List;

import com.studentmanegmentsystem.model.Student;

public interface ServiceI {

	public List<Student> getAllStudent();
	public List<Student> addStudent(Student s);
	
	public List<Student> searchStudentByBatch(String batchNumber);
	public Student getStudent(int id);
	public List<Student> updateStudentFees(int id, float amt);
	public void removeStudent(int id);
	public List<Student> paging(int pageNo, int i);
}
