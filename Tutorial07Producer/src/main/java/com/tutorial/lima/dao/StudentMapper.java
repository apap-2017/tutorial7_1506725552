package com.tutorial.lima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tutorial.lima.model.StudentDBModel;
import com.tutorial.lima.model.StudentModel;

@Mapper
public interface StudentMapper
{
    @Select("select npm, name, gpa from student where npm = #{npm}")
    StudentModel selectStudent (@Param("npm") String npm);
    
    @Select("select s.npm, s.name, s.gpa "
    		+ "from student s, studentcourse sc "
    		+ "where s.npm = sc.npm and sc.id_course = #{id_course};")
    List<StudentDBModel> selectAllStudentsForCourse(@Param("id_course") String idCourse);
	
    @Select("select npm, name, gpa from student")
    List<StudentModel> selectAllStudents ();

    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);
    
    @Delete("DELETE FROM student WHERE npm = #{npm}")
    void deleteStudent(String npm);
    
    @Update("UPDATE student SET name = #{name}, gpa = #{gpa} WHERE npm = #{npm}")
    void updateStudent(StudentModel student);
    
}
