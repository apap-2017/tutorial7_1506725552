package com.tutorial.lima.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDBModel {
	
	private String idCourse;
	private String name;
	private Integer credits;
	
}
