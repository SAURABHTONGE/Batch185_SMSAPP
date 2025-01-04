package com.studentmanegmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanegmentsystem.model.Student;
import com.studentmanegmentsystem.servicei.ServiceI;

@Controller
public class HomeController {

	int i;
	@Autowired
	ServiceI si;
	
	@RequestMapping("/")
	public String prelogin() {
		return "login";
	}
	@RequestMapping("/login")
	public String onlogin(@RequestParam ("username") String username,@RequestParam ("password") String password,Model m) {
		if(username.equals("admin") && password.equals("admin")) {
		m.addAttribute("data",si.getAllStudent());
			return "adminscreen";
		}else {
			return "login";
		}
		}
	@RequestMapping("/enroll_student")
	public String addStudent(@ModelAttribute Student s,Model m) {
		List<Student> list = si.addStudent(s);
		m.addAttribute("data", list);
		return "login";
		
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m) {
		List<Student> result = si.searchStudentByBatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data", result);
		}else {
			List<Student> student = si.getAllStudent();
			m.addAttribute("data", student);
			m.addAttribute("message","No record are availabe for the Batch '" + batchNumber + "'...!");
		}
		return "adminscreen";
		
	}
	@RequestMapping("/fees")
	public String onfees(@RequestParam ("id") int id,Model m) {
		Student s=si.getStudent(id);
		m.addAttribute("st",s);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payfees(@RequestParam ("studentid")int id,@RequestParam("ammount") float amt,Model m) {
		
		List<Student> list=si.updateStudentFees(id,amt);
		m.addAttribute("data",list);
		return "adminscreen";
		}
	@RequestMapping("/remove")
	public String remove(@RequestParam ("id") int id,Model m) {
	
		si.removeStudent(id);
	  List<Student> list=si.getAllStudent();
		m.addAttribute("data",list);
		return "adminscreen";
	}
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m) {
		 List<Student> list=si.paging(pageNo,2);
			m.addAttribute("data",list);
			return "adminscreen";
	}
	@RequestMapping("/batch")
	public String batch(@RequestParam ("id") int id,Model m) {
		Student student = si.getStudent(id);
		m.addAttribute("st", student);
		return "batch";
	}
	@RequestMapping("/updatebatch")
	public String updateBatch(@RequestParam ("studentid")int id,@RequestParam("batchMode") String b,Model m) {
		List<Student> list=si.updateBatch(id,b);
		m.addAttribute("data",list);
		return "adminscreen";
		
	}
	
	
	
	
	
}
