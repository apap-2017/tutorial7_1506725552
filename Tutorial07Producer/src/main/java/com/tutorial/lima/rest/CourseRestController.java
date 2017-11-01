package com.tutorial.lima.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.lima.model.CourseModel;
import com.tutorial.lima.service.CourseService;

@RestController
@RequestMapping("/rest")
public class CourseRestController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/course/view/{idCourse}")
	public CourseModel view(@PathVariable("idCourse") String idCourse) {
		return courseService.selectCourse(idCourse);
	}
	
	@RequestMapping("/course/viewall")
	public List<CourseModel> viewAll(){
		return courseService.selectAll();
	}
	
	
}
