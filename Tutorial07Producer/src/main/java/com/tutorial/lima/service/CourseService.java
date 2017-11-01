package com.tutorial.lima.service;

import java.util.List;

import com.tutorial.lima.model.CourseModel;

public interface CourseService {
	
	CourseModel selectCourse(String idCourse);

	List<CourseModel> selectAll();
	
}
