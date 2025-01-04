package com.studentmanegmentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanegmentsystem.model.Student;
@Repository
public interface RepoI extends JpaRepository<Student,Integer> {

	public List<Student> findAllByBatchNumber(String batchNumber);
}
