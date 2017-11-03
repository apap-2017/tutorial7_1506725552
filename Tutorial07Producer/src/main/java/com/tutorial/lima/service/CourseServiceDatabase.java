package com.tutorial.lima.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.lima.dao.CourseMapper;
import com.tutorial.lima.dao.StudentMapper;
import com.tutorial.lima.model.CourseModel;
import com.tutorial.lima.model.StudentDBModel;

@Service
public class CourseServiceDatabase implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public CourseModel selectCourse(String idCourse) {
		CourseModel course = courseMapper.selectCourse(idCourse);
		if(course != null) {
			List<StudentDBModel> students = studentMapper.selectAllStudentsForCourse(course.getIdCourse());
			if(students == null) {
				students = new ArrayList<>();
			}
			course.setStudents(students);
		}
		return course;
	}

	@Override
	public List<CourseModel> selectAll() {
		List<CourseModel> courses =  courseMapper.selectAllCourses();
		if(courses != null) {
			for(CourseModel course : courses) {
				List<StudentDBModel> students = studentMapper.selectAllStudentsForCourse(course.getIdCourse());
				if(students == null) {
					students = new ArrayList<>();
				}
				course.setStudents(students);
			}
		}else {
			courses = new ArrayList<>();
		}
		return courses;
	}

}
