package com.studentmanegmentsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batchStudent = ri.findAllByBatchNumber(batchNumber);
		return batchStudent;
	}

	@Override
	public Student getStudent(int id) {
		
		return ri.findById(id).get();
	}

	@Override
	public List<Student> updateStudentFees(int id, float amt) {
		Optional<Student> optional = ri.findById(id);
		if(optional.isPresent()) {
			Student s = optional.get();
			s.setFeesPaid(s.getFeesPaid()+amt);
			ri.save(s);
		}
		return ri.findAll();
	}

	@Override
	public void removeStudent(int id) {
		ri.deleteById(id);
		
	}

	@Override
	public List<Student> paging(int pageNo, int i) {
		
		Pageable p=PageRequest.of(pageNo, i, Sort.by("studentFullName").ascending());
		List<Student> list = ri.findAll(p).getContent();
		
		return list;
	}

}
