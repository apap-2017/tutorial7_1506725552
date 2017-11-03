package com.tutorial.lima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tutorial.lima.model.CourseDBModel;
import com.tutorial.lima.model.CourseModel;

@Mapper
public interface CourseMapper {

    @Select("SELECT id_course as idCourse, name, credits  "
    		+ "FROM course "
    		+ "WHERE course.id_course = #{id_course};")
    CourseModel selectCourse (@Param(value = "id_course") String idCourse);

    @Select("select id_course as idCourse, name, credits "
    		+ "from course;")
	List<CourseModel> selectAllCourses();
    
    @Select("select c.id_course as idCourse, c.name, credits "
    		+ "from course c, studentcourse sc "
    		+ "where c.id_course = sc.id_course and sc.npm = #{npm};")
	List<CourseDBModel> selectAllCoursesForStudent(@Param("npm") String npm);
	
}
