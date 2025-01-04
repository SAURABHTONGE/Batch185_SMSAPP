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

	int a;
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
}
