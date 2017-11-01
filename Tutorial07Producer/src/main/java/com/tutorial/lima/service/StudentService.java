package com.tutorial.lima.service;

import java.util.List;

import com.tutorial.lima.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);


    List<StudentModel> selectAllStudents ();


    void addStudent (StudentModel student);


    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
}
