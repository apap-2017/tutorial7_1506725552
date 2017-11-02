package com.tutorial.lima.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.lima.dao.CourseMapper;
import com.tutorial.lima.dao.StudentMapper;
import com.tutorial.lima.model.CourseDBModel;
import com.tutorial.lima.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        StudentModel student =  studentMapper.selectStudent (npm);
        if(student != null) {
	        List<CourseDBModel> courses = courseMapper.selectAllCoursesForStudent(student.getNpm());
	        if(courses == null) {
	        	courses = new ArrayList<>();
	        }
	        student.setCourses(courses);
        }
        return student;
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        List<StudentModel> students = studentMapper.selectAllStudents ();
        if(students != null) {
	        for(StudentModel student : students) {
	        	List<CourseDBModel> courses = courseMapper.selectAllCoursesForStudent(student.getNpm());
	        	if(courses == null) {
	        		courses = new ArrayList<>();
	        	}
	        	student.setCourses(courses);
	        }
        }else {
        	students = new ArrayList<>();
        }
        return students;
    }


    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info("student " + npm + " deleted");
    	studentMapper.deleteStudent(npm);
    }


	@Override
	public void updateStudent (StudentModel student) {
		log.info("student " + student.getNpm() + "diupdate");
		studentMapper.updateStudent(student);
	}
    

}
