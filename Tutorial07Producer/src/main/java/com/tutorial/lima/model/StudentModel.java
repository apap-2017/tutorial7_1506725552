package com.tutorial.lima.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentModel
{
    private String npm;
    private String name;
    private double gpa;
    private List<CourseDBModel> courses;

}