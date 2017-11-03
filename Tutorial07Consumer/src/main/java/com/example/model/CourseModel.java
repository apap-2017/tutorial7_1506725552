package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseModel {
	
	private String idCourse;
	private String name;
	private Integer credits;
	private List<StudentDBModel> students;
	
}
