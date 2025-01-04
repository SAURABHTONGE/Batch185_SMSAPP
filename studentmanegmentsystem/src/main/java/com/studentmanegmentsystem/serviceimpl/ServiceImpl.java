package com.studentmanegmentsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanegmentsystem.model.Student;
import com.studentmanegmentsystem.repository.RepoI;
import com.studentmanegmentsystem.servicei.ServiceI;

@Service
public class ServiceImpl  implements ServiceI{

	@Autowired
	RepoI ri;
	
	@Override
	public List<Student> getAllStudent() {
			return  ri.findAll();
	}

	@Override
	public List<Student> addStudent(Student s) {
		 ri.save(s);
		
		return ri.findAll();
	}

}
