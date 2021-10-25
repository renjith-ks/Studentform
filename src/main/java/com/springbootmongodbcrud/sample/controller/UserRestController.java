package com.springbootmongodbcrud.sample.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodbcrud.sample.entity.Student;
import com.springbootmongodbcrud.sample.service.UserService;




@CrossOrigin(value = "http://localhost:3000/")
@RestController
public class UserRestController {

	@Autowired
	UserService ss;

	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Student save(@RequestBody Student s) {
		
		ss.saveStud(s);
		return s;
		
		
	}

	@RequestMapping(value="/Viewall",method=RequestMethod.GET)
	public List<Student> viewbyname(){
		List<Student> li=ss.getallbyname();
		return li;
		}
	}
