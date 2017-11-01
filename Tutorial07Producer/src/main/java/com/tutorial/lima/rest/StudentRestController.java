package com.tutorial.lima.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.lima.model.StudentModel;
import com.tutorial.lima.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student/view/{npm}")
	public StudentModel view(@PathVariable(value = "npm") String npm) {
		return studentService.selectStudent(npm);
	}
	
	@RequestMapping("/student/viewall")
	public List<StudentModel> viewAll(){
		return studentService.selectAllStudents();
	}
	
}
