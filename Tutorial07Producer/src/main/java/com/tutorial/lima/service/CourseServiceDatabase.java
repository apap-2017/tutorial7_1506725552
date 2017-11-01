package com.tutorial.lima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.lima.dao.CourseMapper;
import com.tutorial.lima.model.CourseModel;

@Service
public class CourseServiceDatabase implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public CourseModel selectCourse(String idCourse) {
		return courseMapper.selectCourse(idCourse);
	}

	@Override
	public List<CourseModel> selectAll() {
		return courseMapper.selectAllCourses();
	}

}
