package com.tutorial.lima.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDBModel {
	
    private String npm;
    private String name;
    private double gpa;
	
}
